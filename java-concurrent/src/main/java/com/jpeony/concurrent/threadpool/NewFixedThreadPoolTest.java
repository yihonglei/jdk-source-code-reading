package com.jpeony.concurrent.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定大小线程，控制最大并发数，无界队列接受任务，任务不丢弃，但是有些任务会等很久才执行。
 *
 * @author yihonglei
 */
public class NewFixedThreadPoolTest {
    private final static Logger logger = LoggerFactory.getLogger(NewFixedThreadPoolTest.class);
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
