package com.lanhuigu.thread.lock.classobject;

/**
 * synchronized 加到 static 方法前面是给class 加锁，即类锁；而synchronized 加到非静态方法前面是给对象上锁。
 * 1、对象锁和类锁是不同的锁，所以多个线程同时执行这2个不同锁的方法时，是异步的。
 */
public class Task {

    public synchronized static void doLongTimeTaskA() {
        System.out.println("name = " + Thread.currentThread().getName() + ", begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end");
    }

    public synchronized static void doLongTimeTaskB() {
        System.out.println("name = " + Thread.currentThread().getName() + ", begain");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end");
    }

    public synchronized void doLongTimeTaskC() {
        System.out.println("name = " + Thread.currentThread().getName() + ", begain");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end");

    }
}
