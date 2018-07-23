package com.lanhuigu.thread.lock.classobject;

public class RunTest {
    public static void main(String[] args) {
        Task mTask = new Task();
        ThreadA ta = new ThreadA(mTask);
        ThreadB tb = new ThreadB(mTask);
        ThreadC tc = new ThreadC(mTask);

        ta.setName("A");
        tb.setName("B");
        tc.setName("C");

        ta.start();
        tb.start();
        tc.start();
    }
}
