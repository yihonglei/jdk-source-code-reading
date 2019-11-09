package com.lanhuigu.thread.waitnotify.notify;

/**
 * 用于处理等待
 *
 * @author yihonglei
 * @date 2019/2/15 16:41
 */
public class ThreadA extends Thread {
    private Object lock;

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
