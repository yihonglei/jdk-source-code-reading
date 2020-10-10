package com.jpeony.concurrent.waitnotify.notifyall;

/**
 * @author yihonglei
 */
public class NotifyThread extends Thread {
    private Object lock;

    public NotifyThread(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("begin general ThreadName = " + Thread.currentThread().getName()
                    + " begin time = " + System.currentTimeMillis());
            // 随机通知一个线程进行唤醒
            lock.notify();
            // 通知全部线程进行唤醒
            // lock.notifyAll();
            System.out.println("end general ThreadName = " + Thread.currentThread().getName()
                    + " end time = " + System.currentTimeMillis());
        }
    }
}