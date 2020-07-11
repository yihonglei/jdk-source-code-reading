package com.jpeony.thread.atomic.ABA;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ABA问题演示
 *
 * @author yihonglei
 *  2019/2/17 10:38
 */
public class AtomicIntegerABA {
    private static AtomicInteger atomicInt = new AtomicInteger(18);

    public static void main(String[] args) throws InterruptedException {
        // 线程A 18-->38
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("===ThreadA begin===");
                atomicInt.compareAndSet(18, 38);
                System.out.println("===ThreadA end===");
            }
        });

        // 线程B 38-->18
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadA.join();
                    System.out.println("===ThreadB begin===");
                    atomicInt.compareAndSet(38, 18);
                    System.out.println("===ThreadB end===");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 线程C 18-->99
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadB.join();
                    System.out.println("===ThreadC begin===");
                    boolean c = atomicInt.compareAndSet(18, 99);
                    System.out.println(c);
                    System.out.println(atomicInt.get());
                    System.out.println("===ThreadC end===");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

        threadC.join();
    }
}
