package com.lanhuigu.thread.countdownlatch;

import com.lanhuigu.thread.threadpool.ThreadPoolUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * 多线程+CountDownLatch演示
 * @author yihonglei
 * @date 2018/8/31 17:22
 */
public class CountDownLatchTest{
    private static final int CORE_THREADS = 50;
    private static ExecutorService executorService = null;

    public static void main(String[] args) {
        start();
    }

    /**
     * 启动线程
     */
    public static void start() {
        int counterBatch = 1;
        try {
            // 开启线程池
            openPool();
            // 数据循环处理
            while (true) {
                // 模拟数据库查询出的List
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    list.add("aaa");
                }
                // 计数器大小定义为集合大小，避免处理不一致导致主线程无限等待
                CountDownLatch countDownLatch = new CountDownLatch(list.size());
                // 循环处理List
                list.parallelStream().forEach(str -> {
                    // 任务提交线程池
                    CompletableFuture.supplyAsync(() -> {
                        try {
                            // 用户数据Check
                            dealUserData(str);
                        } finally {
                            countDownLatch.countDown();
                        }
                        return 1;
                    }, executorService);
                });
                // 主线程等待所有子线程都执行完成时，恢复执行主线程
                countDownLatch.await();
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

                // 数据批次计数器
                counterBatch++;
                // TODO 模拟执行30批
                if (counterBatch >= 30) {
                    break;
                }
            }
            System.out.println("counterBatch=" + counterBatch);
            // 关闭线程池
            closePool();
        } catch (Exception e) {
            System.out.println("异常日志");
        }
    }

    /**
     * 模拟根据用户Id处理用户数据的逻辑
     */
    public static void dealUserData(String uId) {
        System.out.println(Thread.currentThread().getName() + "======用户数据处理完成======");
    }

    /**
     * 开启线程池
     */
    public static void openPool() {
        if (null == executorService || executorService.isShutdown()) {
            executorService = ThreadPoolUtil.newThreadPool("MyThread", CORE_THREADS , CORE_THREADS);
        }
    }

    /**
     * 关闭线程池
     */
    public static void closePool() {
        if (executorService != null) {
            ThreadPoolUtil.shutdown(executorService);
        }
    }

}
