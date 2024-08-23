package com.jpeony.concurrent.synchronizeds.lockobject;

public class ThreadA extends Thread {
    private Task mTask;

    public ThreadA(Task tk) {
        mTask = tk;
    }

    @Override
    public void run() {
        mTask.doLongTimeTaskA();
    }
}
