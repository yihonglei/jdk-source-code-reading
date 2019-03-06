package com.lanhuigu.concurrent;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * hreadPoolExecutor仿写
 *
 * @author yihonglei
 * @date 2019/3/2 11:35
 */
public class ThreadPoolExecutor implements Executor {

    private volatile int corePoolSize;

    private volatile int maximumPoolSize;

    private final BlockingQueue<Runnable> workQueue;

    private final AtomicInteger ctl = new AtomicInteger(0);


    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              BlockingQueue<Runnable> workQueue) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
    }

    /**
     * 暴露任务提交的接口，接收任务
     *
     * @author yihonglei
     * @date 2019/3/2 11:43
     */
    @Override
    public void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException();
        }

        int c = ctl.get();
        if (c < corePoolSize) {
            addWorker(command, true);
        } else if (workQueue.offer(command)) {
            addWorker(null, false);
        } else {
            reject(command);
        }

    }

    private void reject(Runnable command) {
        throw new RuntimeException("线程处理不了，先抛个异常");
    }

    private void addWorker(Runnable task, boolean core) {
        if (core) {
            ctl.incrementAndGet();
        }
        Worker w = new Worker(task);
        w.thread.start();
    }

    private final class Worker extends ReentrantLock implements Runnable{
        final Thread thread;
        Runnable firstTask;

        public Worker(Runnable firstTask) {
            this.firstTask = firstTask;
            thread = new Thread(this);
        }

        @Override
        public void run() {
            runWorker(this);
        }

        private void runWorker(Worker w) {
            try {
                w.lock();
                Runnable task = w.firstTask;

                if (task != null || (task = getTask()) != null) {
                    task.run();
                }
            } finally {
                w.unlock();
            }
        }

        private Runnable getTask() {
            try {
                if (workQueue.isEmpty()) {
                    return null;
                }

                Runnable r = workQueue.take();

                if (r != null) {
                    return r;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }
    }




}
