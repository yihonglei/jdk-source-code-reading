package com.lanhuigu.lock;

public class ThreadC extends Thread {
    private Task2 mTask2;

    public ThreadC(Task2 tk){
        mTask2 = tk;
    }

    public void run() {
        mTask2.doLongTimeTaskC();
    }
}
