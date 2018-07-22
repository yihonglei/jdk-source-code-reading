package com.lanhuigu.thread.reentrantlock.demo1;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();

    public void serviceMethod() {
        lock.lock();
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadName = " + Thread.currentThread().getName()
                    + ", valiable = " + (i + 1));
        }
        lock.unlock();
    }
}