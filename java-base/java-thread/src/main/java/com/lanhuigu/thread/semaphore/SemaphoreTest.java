package com.lanhuigu.thread.semaphore;

import java.util.concurrent.*;

/**
 * Semaphore实例演示
 * @author yihonglei
 * @date 2018/8/5 11:35
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;

    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        /** 自定义线程池 */
        int coreSize = THREAD_COUNT;
        int maxThreads = THREAD_COUNT;
        int keepAliveTime = 60;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(1024);
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread();
            }
        };
        ExecutorService executorService = new ThreadPoolExecutor(coreSize, maxThreads, keepAliveTime, timeUnit, blockingQueue, threadFactory);


        for (int i =0; i <THREAD_COUNT; i++) {
            // 提交任务
            executorService.execute(()-> {
                try {
                    // 获取信号量
                    s.acquire();
                    System.out.println("逻辑处理--save data");
                    // 释放信号量
                    s.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        // 关闭线程池
        executorService.shutdown();
    }
}
