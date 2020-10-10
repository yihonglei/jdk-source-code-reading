package com.jpeony.concurrent.locks.reentrantreadwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yihonglei
 */
public class ReentrantReadWriteLockSimple {
    private final static ReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        Thread writeThread = new Thread(new WriteTask());
        Thread readThread = new Thread(new ReadTask());

        writeThread.start();
        readThread.start();
    }

    private static class WriteTask implements Runnable {
        @Override
        public void run() {
            try {
                lock.writeLock().lock();
                System.out.println("写-start");
                Thread.sleep(10000);
                System.out.println("写-end");
            } catch (InterruptedException e) {
                // ignore
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    private static class ReadTask implements Runnable {
        @Override
        public void run() {
            try {
                lock.readLock().lock();
                System.out.println("读-start");
                Thread.sleep(2000);
                System.out.println("读-end");
            } catch (InterruptedException e) {
                // ignore
            } finally {
                lock.readLock().unlock();
            }
        }
    }
}
