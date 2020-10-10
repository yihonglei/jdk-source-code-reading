package com.jpeony.concurrent.locks.reentrantlock.demo2;

/**
 * 线程
 *
 * @author yihonglei
 */
public class MyThread extends Thread {
    private MyService service;

    public MyThread(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
