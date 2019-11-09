package com.lanhuigu.thread.threadlocal;

public class RunTest {
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
