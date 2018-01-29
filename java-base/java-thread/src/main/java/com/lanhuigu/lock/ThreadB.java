package com.lanhuigu.lock;

public class ThreadB extends Thread {
    private Task2 mTask2;

    public ThreadB(Task2 tk){
        mTask2 = tk;
    }

    public void run() {
        mTask2.doLongTimeTaskB();
    }
}
