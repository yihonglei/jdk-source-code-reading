package com.lanhuigu.thread.reentrantlock.demo3;

public class ThreadB extends Thread{
    private MyService service;

    public ThreadB(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitB();
    }
}
