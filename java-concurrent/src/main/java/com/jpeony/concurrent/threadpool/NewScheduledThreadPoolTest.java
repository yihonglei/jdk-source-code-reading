package com.jpeony.concurrent.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 【计划任务】
 * 1、重复任务：提交任务多长时间之后，周期性执行；
 * 2、一次性任务：提交任务多长时间之后，执行一次；
 */
public class NewScheduledThreadPoolTest {
    private final static Logger logger = LoggerFactory.getLogger(NewScheduledThreadPoolTest.class);

    public static void main(String[] args) {
        // 线程池
        ScheduledThreadPoolExecutor ste = new ScheduledThreadPoolExecutor(1);
        Runnable runnable = () -> logger.info("ThreadName={},Time={}", Thread.currentThread().getName(), new Date());
        // 定时重复执行
        ste.scheduleAtFixedRate(runnable, 5, 5, TimeUnit.SECONDS);
        // 延时执行
        // ste.scheduleWithFixedDelay(runnable, 1, 1, TimeUnit.SECONDS);
    }
}
