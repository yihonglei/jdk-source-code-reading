package com.jpeony.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 休眠停止：让线程处于休眠状态，再调用interrupt()，线程抛异常中断。
 *
 * @author yihonglei
 */
public class SleepInterruptThread extends Thread {
    private final static Logger logger = LoggerFactory.getLogger(SleepInterruptThread.class);

    @Override
    public void run() {
        try {
            logger.info("begin time = {}", System.currentTimeMillis());
            // 长时间休眠，测试休眠中调用interrupt方法
            Thread.sleep(500000);
            logger.info("end time = {}", System.currentTimeMillis());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            SleepInterruptThread sleepInterruptThread = new SleepInterruptThread();
            sleepInterruptThread.start();

            Thread.sleep(2000);
            sleepInterruptThread.interrupt();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
