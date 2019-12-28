package com.lanhuigu.thread.locks.fair;

import java.util.concurrent.locks.ReentrantLock;

public class Service {
    private ReentrantLock lock;

    public Service(boolean isFair) {
        super();
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            lock.lock();
            System.out.println("ThreadName= " + Thread.currentThread().getName() + " 获得锁");
        } finally {
            lock.unlock();
        }
    }
}
