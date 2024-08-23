package com.jpeony.concurrent.threadlocal;

/**
 * ThreadLocal 线程隔离测试
 */
public class RunIsolation {
    public static void main(String[] args) {
        try {
            ThreadA threadA = new ThreadA();
            threadA.start();

            Thread.sleep(3000);

            ThreadB threadB = new ThreadB();
            threadB.start();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
