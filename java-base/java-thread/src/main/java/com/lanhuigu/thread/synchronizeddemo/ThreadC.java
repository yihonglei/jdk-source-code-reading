package com.lanhuigu.thread.synchronizeddemo;

public class ThreadC extends Thread{
    private Task mTask;

    public ThreadC(Task tk){
        mTask = tk;
    }

    @Override
    public void run() {
        mTask.doLongTimeTaskC();
    }
}
