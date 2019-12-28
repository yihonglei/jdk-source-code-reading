package com.lanhuigu.thread.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程+CountDownLatch演示
 *
 * @author yihonglei
 */
public class CountDownLatchDemo {
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        int counterBatch = 1;
        try {
            // 数据循环处理
            while (true) {
                // 模拟数据库查询出的List
                List<String> list = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    list.add("user" + i);
                }

                // 计数器大小定义为集合大小，避免处理不一致导致主线程无限等待
                CountDownLatch countDownLatch = new CountDownLatch(list.size());

//                for (int i = 0; i < list.size(); i++) {
//                    countDownLatch.countDown();
//                }

                // 循环处理List
//                list.parallelStream().forEach(userId -> {
//                    // 任务提交线程池
//                    CompletableFuture.supplyAsync(() -> {
//                        try {
//                            // 处理用户数据
//                            dealUser(userId);
//                        } finally {
//                            countDownLatch.countDown();
//                        }
//                        return 1;
//                    }, executorService);
//                });

                // 循环处理List
                list.forEach(userId -> {
                    executorService.execute(new Thread(() -> {
                        try {
                            // 处理用户数据
                            dealUser(userId);
                        } finally {
                            countDownLatch.countDown();
                        }
                    }));
                });

                // 主线程等待所有子线程都执行完成时，恢复执行主线程
                countDownLatch.await();
                System.out.println("========================恢复主线程执行==========================");

                // 数据批次计数器
                counterBatch++;

                break;

                // 模拟执行5批
//                if (counterBatch > 5) {
//                    break;
//                }
            }
            System.out.println("循环退出，程序执行完成，counterBatch=" + counterBatch);

            // 关闭线程池
            executorService.shutdown();
        } catch (Exception e) {
            System.out.println("异常日志");
        }
    }

    /**
     * 模拟根据用户Id处理用户数据的逻辑
     */
    private static void dealUser(String userId) {
        System.out.println("ThreadName:" + Thread.currentThread().getName() + ", userId:" + userId + " 处理完成！");
    }

}
