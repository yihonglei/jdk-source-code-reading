package com.jpeony.concurrent.synchronizeds.lockobject;

public class ThreadB extends Thread {
    private Task mTask;

    public ThreadB(Task tk) {
        mTask = tk;
    }

    @Override
    public void run() {
        mTask.doLongTimeTaskB();
    }
}