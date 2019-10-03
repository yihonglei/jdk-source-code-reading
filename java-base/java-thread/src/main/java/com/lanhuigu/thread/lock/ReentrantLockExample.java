package com.lanhuigu.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yihonglei
 * @date 2018/8/3 11:02
 */
public class ReentrantLockExample {
    int a = 0;
    ReentrantLock lock = new ReentrantLock();

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
