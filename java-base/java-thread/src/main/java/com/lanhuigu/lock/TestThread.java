package com.lanhuigu.lock;

public class TestThread {

    public static void main(String[] args) {
        Task2 mTask2 = new Task2();
        ThreadA ta = new ThreadA(mTask2);
        ThreadB tb = new ThreadB(mTask2);
        ThreadC tc = new ThreadC(mTask2);

        ta.setName("A");
        tb.setName("B");
        tc.setName("C");

        ta.start();
        tb.start();
        tc.start();
    }

}
