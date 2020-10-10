package com.jpeony.concurrent.synchronizeds.lockclass;

/**
 * @author yihonglei
 */
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