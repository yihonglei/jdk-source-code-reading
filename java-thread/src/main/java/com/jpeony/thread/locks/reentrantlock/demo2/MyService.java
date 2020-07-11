package com.jpeony.thread.locks.reentrantlock.demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * 等待
     */
    public void await() {
        try {
            lock.lock();
            System.out.println("await time:" + System.currentTimeMillis());
            condition.await(); // 使线程处于等待状态
        } catch (InterruptedException ex) {// 线程中断异常
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 通知
     */
    public void signal() {
        try {
            lock.lock();
            System.out.println("signal time:" + System.currentTimeMillis());
            condition.signal();// 通知等待线程进行唤醒
        } catch (IllegalMonitorStateException ex) {// 监视器不合法异常
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
