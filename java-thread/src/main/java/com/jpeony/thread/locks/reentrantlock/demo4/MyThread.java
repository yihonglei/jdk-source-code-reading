package com.jpeony.thread.locks.reentrantlock.demo4;

/**
 * @author yihonglei
 */
public class MyThread extends Thread {
    private Task task;

    public MyThread(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println("run方法begin");
        task.await();
        System.out.println("run方法end");
    }
}
