package com.lanhuigu.pool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestNewFixedThreadPool {
    public static final int DEFAULT_CORE_THREADS = Runtime.getRuntime().availableProcessors();

    public TestNewFixedThreadPool() {

    }

    public static ExecutorService newThreadPool(String threadPrefix) {
        return newThreadPool(threadPrefix, DEFAULT_CORE_THREADS, DEFAULT_CORE_THREADS);
    }

    public static ExecutorService newThreadPool(String threadPrefix, int coreThreads, int maxThreads) {
        final LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<Runnable>(1024);
        ExecutorService executorService = new ThreadPoolExecutor(coreThreads, maxThreads, 60L, TimeUnit.SECONDS, blockingQueue, new ThreadFactory() {
            final AtomicInteger counter = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName(threadPrefix + "-" + this.counter.incrementAndGet());
                t.setDaemon(true);
                t.setPriority(5);
                return t;
            }
        },new RejectedExecutionHandler(){

            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                try {
                    blockingQueue.put(r);
                } catch (InterruptedException var4) {
                    /** 异常处理 */
                }
            }
        });

        return executorService;
    }
}
