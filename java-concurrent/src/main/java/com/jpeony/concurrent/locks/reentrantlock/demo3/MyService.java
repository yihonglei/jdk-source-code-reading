package com.jpeony.concurrent.locks.reentrantlock.demo3;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多等待/多通知实现
 */
public class MyService {
    private final static Logger logger = LoggerFactory.getLogger(MyService.class);
    private Lock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    /**
     * A等待
     */
    public void awaitA() {
        try {
            lock.lock();
            logger.info("waitA begin time:{}", System.currentTimeMillis());
            conditionA.await();// 等待
            logger.info("waitA end time:{}", System.currentTimeMillis());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * B等待
     */
    public void awaitB() {
        try {
            lock.lock();
            logger.info("waitB begin time:{}", System.currentTimeMillis());
            conditionB.await();// 等待
            logger.info("waitB end time:{}", System.currentTimeMillis());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * conditionA通知:
     * signal() 通知单个线程
     * signalAll() 通知所有线程
     */
    public void signalAll_A() {
        try {
            lock.lock();
            logger.info("signalAll_A begin time:{}, ThreadName = {}", System.currentTimeMillis(), Thread.currentThread().getName());
            // 通知conditionA监视器中所有处于等待的线程进行唤醒
            conditionA.signalAll();
        } catch (IllegalMonitorStateException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * conditionB通知:
     * signal() 通知单个线程
     * signalAll() 通知所有线程
     */
    public void signalAll_B() {
        try {
            lock.lock();
            logger.info("signalAll_B begin time:{}, ThreadName = {}", System.currentTimeMillis(), Thread.currentThread().getName());
            // 通知conditionB监视器中所有处于等待的线程进行唤醒
            conditionB.signalAll();
        } catch (IllegalMonitorStateException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
