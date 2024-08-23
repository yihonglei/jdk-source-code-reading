package com.jpeony.concurrent.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池只有一个线程，任务按队列先进先出顺序执行。
 */
public class NewSingleThreadExecutorTest {
    private final static Logger logger = LoggerFactory.getLogger(NewScheduledThreadPoolTest.class);
    // 线程池
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int finalSeqNum = i + 1;
            Runnable runnable = () -> logger.info("ThreadName={}, seqNum={}", Thread.currentThread().getName(), finalSeqNum);
            executorService.execute(runnable);
        }
    }
}
