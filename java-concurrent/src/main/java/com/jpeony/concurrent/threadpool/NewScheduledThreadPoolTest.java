package com.jpeony.concurrent.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定时或周期执行任务
 *
 * @author yihonglei
 */
public class NewScheduledThreadPoolTest {
    private final static Logger logger = LoggerFactory.getLogger(NewScheduledThreadPoolTest.class);

    public static void main(String[] args) {
        // 线程池
        ScheduledThreadPoolExecutor ste = new ScheduledThreadPoolExecutor(1);
        Runnable runnable = () -> logger.info("ThreadName={},Time={}", Thread.currentThread().getName());
        ste.scheduleAtFixedRate(runnable, 5, 5, TimeUnit.SECONDS);
    }
}
