package com.jpeony.concurrent.locks.countdownlatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch 演示
 *
 * @author yihonglei
 */
public class CountDownLatchTest {
    private final static Logger logger = LoggerFactory.getLogger(CountDownLatchTest.class);
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

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
                // 循环处理List
                list.parallelStream().forEach(userId -> {
                    // 任务提交线程池
                    CompletableFuture.supplyAsync(() -> {
                        try {
                            // 处理用户数据
                            dealUser(userId);
                        } finally {
                            countDownLatch.countDown();
                        }
                        return 1;
                    }, executorService);
                });
                // 主线程等待所有子线程都执行完成时，恢复执行主线程
                countDownLatch.await();
                logger.info("========================恢复主线程执行==========================");
                // 数据批次计数器
                counterBatch++;
                // 模拟执行5批
                if (counterBatch > 5) {
                    break;
                }
            }
            logger.info("循环退出，程序执行完成，counterBatch={}", counterBatch);
            // 关闭线程池
            executorService.shutdown();
        } catch (Exception e) {
            logger.error("异常日志", e);
        }
    }

    /**
     * 模拟根据用户Id处理用户数据的逻辑
     */
    private static void dealUser(String userId) {
        logger.info("ThreadName:{}, userId:{} 处理完成!", Thread.currentThread().getName(), userId);
    }

}
