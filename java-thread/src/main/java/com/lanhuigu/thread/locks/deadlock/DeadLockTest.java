package com.lanhuigu.thread.locks.deadlock;

/**
 * 死锁演示:
 * 1、线程1拿到lock1锁，然后执行等待5秒，5秒后获取lock2锁；
 * 2、线程2拿到lock2锁，然后执行等待5秒，5秒后获取lock1锁；
 * 3、线程1在5秒后拿lock2，但是lock2被线程2持有还未释放，同样，
 * 线程2在5秒后拿lock1，但是lock2被线程1持有未释放，这样就导致了两个线程都获取不到锁，
 * 相互等待，导致了死锁问题。
 *
 * @author yihonglei
 * @date 2019/3/23 15:41
 */
public class DeadLockTest {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        new DeadLockTest().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    System.out.println("Thread-1 start ......");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock2) {
                    System.out.println("Thread-1 end!");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    System.out.println("Thread-2 start ......");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {
                    System.out.println("Thread-2 end!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
