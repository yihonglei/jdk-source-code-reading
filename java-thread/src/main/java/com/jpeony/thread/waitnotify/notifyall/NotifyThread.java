package com.jpeony.thread.waitnotify.notifyall;

/**
 * @author yihonglei
 *  2019/2/15 11:23
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
            // lock.notify();// 随机通知一个线程进行唤醒
            lock.notifyAll();// 通知全部线程进行唤醒
            System.out.println("end general ThreadName = " + Thread.currentThread().getName()
                    + " end time = " + System.currentTimeMillis());
        }
    }
}
