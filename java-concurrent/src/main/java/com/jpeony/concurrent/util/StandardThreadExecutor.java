package com.jpeony.concurrent.util;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 代码和思路主要来自于：
 * tomcat：org.apache.catalina.core.StandardThreadExecutor
 * <p>
 * 1、CPU密集（主要进行本地大量业务处理，计算等等，这个时候要控制好线程，否则，CPU占用大量资源，系统极度缓慢和崩掉）
 * java.util.concurrent#ThreadPoolExecutor execute()执行策略：
 * 优先offer到queue，queue满后再扩充线程到maximumPoolSize，如果已经到了maximumPoolSize就reject
 * 比较适合于CPU密集型应用（比如runnable内部执行的操作都在JVM内部，memory copy, or compute等等）
 * <p>
 * 2、IO密集（本地处理比较少，大量远程调用希望得到及时响应，这个时候在资源允许范围内开启尽量多的线程去处理）
 * StandardThreadExecutor execute()执行策略：
 * 优先扩充线程到maximumPoolSize，再offer到queue，如果满了就reject，比较适合于业务处理需要远程资源的场景
 *
 * @author yihonglei
 */
public class StandardThreadExecutor extends ThreadPoolExecutor {
    /**
     * min number of threads
     */
    protected static final int DEFAULT_MIN_THREADS = 20;

    /**
     * max number of threads
     */
    protected static final int DEFAULT_MAX_THREADS = 200;

    /**
     * idle time in milliseconds(1 minutes)
     */
    protected static final int DEFAULT_MAX_IDLE_TIME = 60 * 1000;

    /**
     * 正在处理的任务数
     */
    protected AtomicInteger submittedTasksCount;
    /**
     * 最大允许同时处理的任务数
     */
    private int maxSubmittedTaskCount;

    public StandardThreadExecutor() {
        this(DEFAULT_MIN_THREADS, DEFAULT_MAX_THREADS);
    }

    public StandardThreadExecutor(int coreThreads, int maxThreads) {
        this(coreThreads, maxThreads, maxThreads);
    }

    public StandardThreadExecutor(int coreThreads, int maxThreads, int queueCapacity) {
        this(coreThreads, maxThreads, queueCapacity, Executors.defaultThreadFactory());
    }

    public StandardThreadExecutor(int coreThreads, int maxThreads, int queueCapacity, ThreadFactory threadFactory) {
        this(coreThreads, maxThreads, DEFAULT_MAX_IDLE_TIME, TimeUnit.MILLISECONDS, queueCapacity, threadFactory);
    }

    public StandardThreadExecutor(int coreThreads, int maxThreads, long keepAliveTime, TimeUnit unit) {
        this(coreThreads, maxThreads, keepAliveTime, unit, maxThreads);
    }

    public StandardThreadExecutor(int coreThreads, int maxThreads, long keepAliveTime, TimeUnit unit, int queueCapacity) {
        this(coreThreads, maxThreads, keepAliveTime, unit, queueCapacity, Executors.defaultThreadFactory());
    }

    public StandardThreadExecutor(int coreThreads, int maxThreads, long keepAliveTime, TimeUnit unit,
                                  int queueCapacity, ThreadFactory threadFactory) {
        this(coreThreads, maxThreads, keepAliveTime, unit, queueCapacity, threadFactory, new AbortPolicy());
    }

    public StandardThreadExecutor(int coreThreads, int maxThreads, long keepAliveTime, TimeUnit unit,
                                  int queueCapacity, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(coreThreads, maxThreads, keepAliveTime, unit, new TaskQueue(), threadFactory, handler);
        ((TaskQueue) getQueue()).setStandardThreadExecutor(this);

        submittedTasksCount = new AtomicInteger(0);

        // 最大并发任务限制：队列buffer数 + 最大线程数
        // 这种队列首先创建线程，其次放到任务队列
        maxSubmittedTaskCount = queueCapacity + maxThreads;
    }

    @Override
    public void execute(Runnable command) {
        int count = submittedTasksCount.incrementAndGet();

        // 超过最大的并发任务限制，进行reject
        // 依赖的LinkedTransferQueue没有长度限制，因此这里进行控制
        if (count > maxSubmittedTaskCount) {
            submittedTasksCount.decrementAndGet();
            getRejectedExecutionHandler().rejectedExecution(command, this);
        }

        try {
            super.execute(command);
        } catch (RejectedExecutionException rx) {
            // there could have been contention around the queue
            if (!((TaskQueue) getQueue()).force(command)) {
                submittedTasksCount.decrementAndGet();
                getRejectedExecutionHandler().rejectedExecution(command, this);
            }
        }
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        submittedTasksCount.decrementAndGet();
    }

    public Integer getSubmittedTasksCount() {
        return this.submittedTasksCount.get();
    }

    public int getMaxSubmittedTaskCount() {
        return maxSubmittedTaskCount;
    }
}

/**
 * LinkedTransferQueue 能保证更高性能，相比与LinkedBlockingQueue有明显提升，
 * 不过LinkedTransferQueue的缺点是没有队列长度控制，需要在外层协助控制。
 *
 * @author yihonglei
 */
class TaskQueue extends LinkedTransferQueue<Runnable> {
    private static final long serialVersionUID = -265236426751004839L;
    private StandardThreadExecutor threadPoolExecutor;

    public TaskQueue() {
        super();
    }

    public void setStandardThreadExecutor(StandardThreadExecutor threadPoolExecutor) {
        this.threadPoolExecutor = threadPoolExecutor;
    }

    /**
     * Note：The code comes from Tomcat's TaskQueue modification.
     *
     * @author yihonglei
     */
    public boolean force(Runnable o) {
        if (threadPoolExecutor.isShutdown()) {
            throw new RejectedExecutionException("Executor not running, can't force a command into the queue");
        }
        // forces the item onto the queue, to be used if the task is rejected
        return super.offer(o);
    }

    /**
     * Note：The code comes from Tomcat's TaskQueue modification.
     *
     * @author yihonglei
     */
    @Override
    public boolean offer(Runnable o) {
        // Returns the current number of threads in the pool, from HashSet<Worker> workers.size()
        int poolSize = threadPoolExecutor.getPoolSize();

        // we are maxed out on threads, simply queue the object
        if (poolSize == threadPoolExecutor.getMaximumPoolSize()) {
            return super.offer(o);
        }
        // we have idle threads, just add it to the queue
        // note that we don't use getActiveCount(), see BZ 49730
        if (threadPoolExecutor.getSubmittedTasksCount() <= poolSize) {
            return super.offer(o);
        }
        // if we have less threads than maximum force creation of a new thread
        if (poolSize < threadPoolExecutor.getMaximumPoolSize()) {
            return false;
        }
        // if we reached here, we need to add it to the queue
        return super.offer(o);
    }
}
