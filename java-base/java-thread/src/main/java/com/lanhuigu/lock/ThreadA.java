package com.lanhuigu.lock;

public class ThreadA extends Thread {
    private Task2 mTask2;

    public ThreadA(Task2 tk){
        mTask2 = tk;
    }

    public void run() {
        mTask2.doLongTimeTaskA();
    }
}
