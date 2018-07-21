package com.lanhuigu.thread.stopthread;
/**
 * 在sleep状态下停止某个线程，会进入catch语句，同时清除线程停止状态值变为false.
 */
public class SleepInterruptThread extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("begin time = " + System.currentTimeMillis());
            Thread.sleep(500000);// 长时间休眠，测试休眠中调用interrupt方法
            System.out.println("end time = " + System.currentTimeMillis());
        } catch (InterruptedException ex) {
            System.out.println("catch......");
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
