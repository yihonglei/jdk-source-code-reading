package com.jpeony.concurrent.waitnotify.yes;

/**
 * 用于处理通知
 *
 * @author yihonglei
 */
public class ThreadB extends Thread {
    private final Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("notify-ThreadB begin time = " + System.currentTimeMillis());
            lock.notify();
            System.out.println("notify-ThreadB end time = " + System.currentTimeMillis());
        }
    }
}

