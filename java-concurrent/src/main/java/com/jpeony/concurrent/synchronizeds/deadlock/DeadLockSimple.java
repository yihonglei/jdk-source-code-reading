package com.jpeony.concurrent.synchronizeds.deadlock;

/**
 * @author yihonglei
 */
public class DeadLockSimple {
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockSimple().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (B) {
                        System.out.println("1");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
