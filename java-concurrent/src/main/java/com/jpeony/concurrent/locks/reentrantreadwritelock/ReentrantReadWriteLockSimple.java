package com.jpeony.concurrent.locks.reentrantreadwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 写锁（互斥锁）：当有读或写锁，不能加写锁，进入阻塞队列等待；
 * 读锁（共享锁）：当有写锁，不能加读锁，进入阻塞队列等待；
 * @author yihonglei
 */
public class ReentrantReadWriteLockSimple {
    private final static ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        Thread writeThread = new Thread(new WriteTask());
        Thread readThread1 = new Thread(new ReadTask1());
        Thread readThread2 = new Thread(new ReadTask2());

//        writeThread.start();
        readThread1.start();
        readThread2.start();

    }

    private static class WriteTask implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("写-WriteTask-lock");
                lock.writeLock().lock();
                System.out.println("写-WriteTask-start");
                Thread.sleep(10000);
                System.out.println("写-WriteTask-end");
            } catch (InterruptedException e) {
                // ignore
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    private static class ReadTask1 implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("读-ReadTask1-lock");
                lock.readLock().lock();
                System.out.println("读-ReadTask1-start");
                Thread.sleep(5000);
                System.out.println("读-ReadTask1-end");
            } catch (InterruptedException e) {
                // ignore
            } finally {
                lock.readLock().unlock();
            }
        }
    }

    private static class ReadTask2 implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("读-ReadTask2-lock");
                lock.readLock().lock();
                System.out.println("读-ReadTask2-start");
                Thread.sleep(1000);
                System.out.println("读-ReadTask2-end");
            } catch (InterruptedException e) {
                // ignore
            } finally {
                lock.readLock().unlock();
            }
        }
    }
}
