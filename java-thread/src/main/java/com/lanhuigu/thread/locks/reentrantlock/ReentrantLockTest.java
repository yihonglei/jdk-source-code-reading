package com.lanhuigu.thread.locks.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 锁内存语义的实现。
 *
 * @author yihonglei
 */
public class ReentrantLockTest {
    private int a = 0;
    private ReentrantLock lock = new ReentrantLock();

    public void writer() {
        lock.lock();
        try {
            a++;
        } finally {
            lock.unlock();
        }
    }

    public void reader() {
        lock.lock();
        try {
            int i = a;
        } finally {
            lock.unlock();
        }
    }
}
