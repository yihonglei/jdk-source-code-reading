package com.lanhuigu.thread.locks.reentrantlock.demo1;

public class MyThread extends Thread{
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
