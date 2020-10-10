package com.jpeony.concurrent.locks.reentrantlock.demo1;

/**
 * 调用service的线程
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
        service.serviceMethod();
    }
}