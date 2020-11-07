package com.jpeony.concurrent.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 提交任务到线程池看源码入口
 *
 * @author yihonglei
 */
public class ThreadPoolExecutorTest {
    private final static Logger logger = LoggerFactory.getLogger(ThreadPoolExecutorTest.class);
    // 线程池
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            int finalSeqNum = i + 1;
            Runnable runnable = () -> logger.info("ThreadName={}, seqNum={}", Thread.currentThread().getName(), finalSeqNum);
            executorService.execute(runnable);
        }
    }
}
