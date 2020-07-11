package com.jpeony.thread.threadmethod;

/**
 * Thread类中的sleep(long millis)方法让当前正在执行的线程休眠指定毫秒数
 */
public class SleepMethod extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("ThreadName = " + Thread.currentThread().getName() + " begin time = " + System.currentTimeMillis());
            // 休眠3000毫秒(3秒)
            Thread.sleep(3000);
            System.out.println("ThreadName = " + Thread.currentThread().getName() + " end time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SleepMethod sleepThread = new SleepMethod();
        sleepThread.start();
    }
}
