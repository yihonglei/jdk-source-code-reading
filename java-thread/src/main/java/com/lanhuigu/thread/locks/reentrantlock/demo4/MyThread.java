package com.lanhuigu.thread.locks.reentrantlock.demo4;

/**
 * @author yihonglei
 * @date 2019/2/12 17:16
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
