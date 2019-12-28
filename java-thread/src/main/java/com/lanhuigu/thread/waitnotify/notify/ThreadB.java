package com.lanhuigu.thread.waitnotify.notify;

/**
 * 用于处理通知
 *
 * @author yihonglei
 *  2019/2/15 16:42
 */
public class ThreadB extends Thread {
    private Object lock;

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
