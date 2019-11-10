package com.lanhuigu.thread.locks.reentrantlock.demo4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yihonglei
 * @date 2019/2/12 17:17
 */
public class Task {

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void await() {
        try {
            lock.lock();

            condition.await();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signal() {
        try {
            lock.lock();

            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
