package com.lanhuigu.thread.locks.reentrantlock.demo2;

public class MyThread extends Thread{
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
