package com.jpeony.concurrent.locks.reentrantlock.demo3;

/**
 * 线程A
 *
 * @author yihonglei
 */
public class ThreadA extends Thread {
    private MyService service;

    public ThreadA(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitA();
    }
}
