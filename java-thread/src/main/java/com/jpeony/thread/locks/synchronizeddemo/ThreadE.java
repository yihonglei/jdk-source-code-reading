package com.jpeony.thread.locks.synchronizeddemo;

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
