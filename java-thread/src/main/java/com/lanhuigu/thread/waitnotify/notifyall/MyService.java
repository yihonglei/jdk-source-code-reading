package com.lanhuigu.thread.waitnotify.notifyall;

/**
 * @author yihonglei
 * @date 2019/2/15 11:21
 */
public class MyService {
    public void serviceMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait ThreadName = " + Thread.currentThread().getName()
                        + " begin time = " + System.currentTimeMillis());
                lock.wait();
                System.out.println("end wait ThreadName = " + Thread.currentThread().getName()
                        + " end time = " + System.currentTimeMillis());
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
