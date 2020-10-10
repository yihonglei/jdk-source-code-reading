package com.jpeony.concurrent.locks.reentrantlock.demo3;

/**
 * 线程B
 *
 * @author yihonglei
 */
public class ThreadB extends Thread {
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
