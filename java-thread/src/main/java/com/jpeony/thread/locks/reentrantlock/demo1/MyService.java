package com.jpeony.thread.locks.reentrantlock.demo1;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock = new ReentrantLock();

    public void serviceMethod() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + ", begin ");
        } finally {
            System.out.println(Thread.currentThread().getName() + ", end ");
            lock.unlock();
        }
    }
}