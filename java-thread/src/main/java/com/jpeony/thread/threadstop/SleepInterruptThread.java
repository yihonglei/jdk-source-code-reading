package com.jpeony.thread.threadstop;

/**
 * 休眠停止：
 * 让线程处于休眠状态，再调用interrupt()，线程抛异常中断。
 */
public class SleepInterruptThread extends Thread {
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
