package com.lanhuigu.thread.threadpool;

import java.util.concurrent.*;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: MyThreadPool
 * @Package: com.lanhuigu.thread.threadpool
 * @date 2018/8/5 17:32
 */
public class MyThreadPool {
    public static ExecutorService newThreadPool() {
        int corePoolSize = 1;
        int maximumPool = 10;
        int keepAliveTime = 60;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(5);
        ExecutorService executorService = new ThreadPoolExecutor(corePoolSize, maximumPool, keepAliveTime,
                timeUnit, blockingQueue, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread();
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//                blockingQueue.add(r);
                System.out.println("线程被拒绝了");
            }
        });

        return executorService;
    }

    public static void main(String[] args) {
        ExecutorService executorService = MyThreadPool.newThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Thread("My-Thread-" + i));
        }
    }
}
