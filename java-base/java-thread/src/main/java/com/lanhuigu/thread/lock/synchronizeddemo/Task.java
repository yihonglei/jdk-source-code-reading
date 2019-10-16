package com.lanhuigu.thread.lock.synchronizeddemo;

/**
 * 可以从synchronized加锁位置区分对象锁和类锁：
 * 1、对象锁
 *
 * 普通同步方法，锁是当前实例对象。比如：
 *
 * public synchronized void doLongTimeTaskC() {}
 *
 * 2、类锁
 *
 * 静态同步方法，锁是当前类的Class对象。比如：
 *
 * public synchronized static void doLongTimeTaskA() {}
 *
 * 3、同步代码块
 *
 * 加在同步代码块上，锁是Synchonized括号里配置的对象，可以是实例对象，也可以是Class对象；
 *
 * public void doLongTimeTaskD() {
 *     synchronized (this) {
 *     }
 * }
 *
 * 或
 *
 * public static void doLongTimeTaskE() {
 *     synchronized (Task.class) {
 *     }
 * }
 *
 * @author yihonglei
 */
public class Task {

    // 静态对象
    private static Object object = new Object();

    /**
     * 对象锁：普通同步方法，锁为当前实例对象。
     */
    public synchronized void doLongTimeTaskA() {
        System.out.println("name = " + Thread.currentThread().getName() + ", begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end");

    }

    /**
     * 对象锁：同步代码块，锁为代码块里面的实例对象。
     */
    public void doLongTimeTaskB() {
        synchronized (this) {
            System.out.println("name = " + Thread.currentThread().getName() + ", begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("name = " + Thread.currentThread().getName() + ", end");
        }
    }

    /**
     * 类锁：静态同步方法，锁为当前Class对象。
     */
    public synchronized static void doLongTimeTaskC() {
        System.out.println("name = " + Thread.currentThread().getName() + ", begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end");
    }

    /**
     * 类锁：静态同步方法，锁为当前Class对象。
     */
    public synchronized static void doLongTimeTaskD() {
        System.out.println("name = " + Thread.currentThread().getName() + ", begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end");
    }

    /**
     * 同步代码块：里面的对象可以是Class对象，也可以是实例对象。
     */
    public static void doLongTimeTaskE() {
        synchronized (Task.class) {// Class对象
        //synchronized (object) {// 实例对象
            System.out.println("name = " + Thread.currentThread().getName() + ", begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("name = " + Thread.currentThread().getName() + ", end");
        }
    }
}
