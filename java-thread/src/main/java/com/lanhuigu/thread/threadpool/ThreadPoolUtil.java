package com.lanhuigu.thread.threadpool;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义线程池
 *
 * @author yihonglei
 *  2018/8/31 15:07
 */
public class ThreadPoolUtil {
    public static final int DEFAULT_CORE_THREADS = Runtime.getRuntime().availableProcessors();

    /**
     * 默认创建CPU核心线程数线程池
     *
     * @param threadPrefix 线程名称前缀，给线程取一个有意义的名称，方便问题排查
     * @return java.util.concurrent.ExecutorService
     * @author yihonglei
     *  2018/8/31 15:16
     */
    public static ExecutorService newThreadPool(String threadPrefix) {
        return doNewThreadPool(threadPrefix, DEFAULT_CORE_THREADS, DEFAULT_CORE_THREADS);
    }

    /**
     * 线程池创建
     *
     * @param threadPrefix 线程名称前缀，给线程取一个有意义的名称，方便问题排查
     * @param coreThreads  核心线程池数
     * @param maxThreads   最大线程池数
     * @return java.util.concurrent.ExecutorService
     * @author yihonglei
     *  2018/8/31 15:50
     */
    public static ExecutorService newThreadPool(String threadPrefix, int coreThreads, int maxThreads) {
        return doNewThreadPool(threadPrefix, coreThreads, maxThreads);
    }

    /**
     * 线程池创建
     *
     * @param threadPrefix 线程名称前缀，给线程取一个有意义的名称，方便问题排查
     * @param coreThreads  核心线程池数
     * @param maxThreads   最大线程池数
     * @return java.util.concurrent.ExecutorService
     * @author yihonglei
     *  2018/8/31 15:50
     */
    private static ExecutorService doNewThreadPool(final String threadPrefix, int coreThreads, int maxThreads) {
        /** 线程池阻塞队列 */
        final LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>(1024);
        /** 创建线程池 */
        ExecutorService executorService = new ThreadPoolExecutor(coreThreads, maxThreads, 60, TimeUnit.SECONDS, blockingQueue, new ThreadFactory() {
            /** 创建线程 */
            final AtomicInteger counter = new AtomicInteger();

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName(threadPrefix + "-" + counter.incrementAndGet());
                t.setPriority(Thread.NORM_PRIORITY);
                return t;
            }
        }, new RejectedExecutionHandler() {
            /** 饱和策略 */
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                try {
                    blockingQueue.put(r);
                } catch (InterruptedException e) {
                    System.out.println("TODO-实际项目中用日志框架打日志");
                }
            }
        });
        return executorService;
    }

    /**
     * 关闭线程池
     *
     * @param executorService
     * @return void
     * @author yihonglei
     *  2018/8/31 19:00
     */
    public static void shutdown(ExecutorService executorService) {
        if (!executorService.isShutdown()) {
            executorService.shutdown();
        }
    }


    public static void main(String[] args) {
        ExecutorService myThreadPool = ThreadPoolUtil.newThreadPool("MyThreadPool");

        for (int i = 1; i <= 10; i++) {
            myThreadPool.execute(() -> {
                System.out.println("======" + ThreadLocalRandom.current().nextDouble());
            });
        }
    }

}
