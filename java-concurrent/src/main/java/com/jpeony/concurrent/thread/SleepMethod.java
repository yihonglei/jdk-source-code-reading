package com.jpeony.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Thread类中的sleep(long millis)方法让当前正在执行的线程休眠指定毫秒数
 *
 * @author yihonglei
 */
public class SleepMethod extends Thread {
    private final static Logger logger = LoggerFactory.getLogger(SleepMethod.class);

    @Override
    public void run() {
        try {
            logger.info("ThreadName = {}, begin time = {}", Thread.currentThread().getName(), System.currentTimeMillis());
            // 休眠3000毫秒(3秒)
            Thread.sleep(3000);
            logger.info("ThreadName = {}, end time = {}", Thread.currentThread().getName(), System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SleepMethod sleepThread = new SleepMethod();
        sleepThread.start();
    }
}
