package com.lanhuigu.thread.lock.synchronizeddemo;

public class ThreadE extends Thread {
    private Task mTask;

    public ThreadE(Task tk) {
        mTask = tk;
    }

    @Override
    public void run() {
        mTask.doLongTimeTaskE();
    }
}
