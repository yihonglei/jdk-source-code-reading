package com.jpeony.concurrent.waitnotify.yes;

/**
 * 用于处理等待
 *
 * @author yihonglei
 */
public class ThreadA extends Thread {
    private final Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("wait-ThreadA begin time = " + System.currentTimeMillis());
                lock.wait();
                System.out.println("wait-ThreadA end time = " + System.currentTimeMillis());
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
