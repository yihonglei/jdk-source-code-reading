package com.lanhuigu.thread.lock.reentrantlock.demo2;

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
