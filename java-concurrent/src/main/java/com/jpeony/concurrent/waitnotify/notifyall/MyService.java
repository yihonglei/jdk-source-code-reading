package com.jpeony.concurrent.waitnotify.notifyall;

/**
 * @author yihonglei
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
