package com.jpeony.concurrent.synchronizeds.lockclass;

/**
 * @author yihonglei
 */
public class ThreadD extends Thread {
    private Task mTask;

    public ThreadD(Task tk) {
        mTask = tk;
    }

    @Override
    public void run() {
        mTask.doLongTimeTaskD();
    }
}