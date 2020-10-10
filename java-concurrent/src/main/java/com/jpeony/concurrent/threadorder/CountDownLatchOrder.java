package com.jpeony.concurrent.threadorder;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch控制线程执行顺序，通过await方法为0时，线程才会执行特性，阻塞线程执行，通过上一个线程执行完成，
 * 减掉下一个线程的计数器，使下一个线程计数器为0，线程变为可执行，来控制线程执行顺序。
 *
 * @author yihonglei
 */
public class CountDownLatchOrder {
    public static void main(String[] args) {
        // 计数器为0
        CountDownLatch threadC1 = new CountDownLatch(0);
        // 计数器为1
        CountDownLatch threadC2 = new CountDownLatch(1);
        // 计算器为2
        CountDownLatch threadC3 = new CountDownLatch(1);

        // threadC1计数器为0，t1线程执行，然后threadC2计数器被减为0
        Thread t1 = new Thread(new Work(threadC1, threadC2), "Thread-1");
        // threadC2计数器为0，t2线程执行，然后threadC3计数器被减为0
        Thread t2 = new Thread(new Work(threadC2, threadC3), "Thread-2");
        // threadC3计数器为0，t3线程执行
        Thread t3 = new Thread(new Work(threadC3, threadC3), "Thread-3");
        
        // 启动线程
        t1.start();
        t2.start();
        t3.start();
    }

    static class Work implements Runnable {
        // 当前要执行线程的计数器
        private CountDownLatch current;
        // 下一个要执行线程的计数器
        private CountDownLatch next;

        Work(CountDownLatch current, CountDownLatch next) {
            this.current = current;
            this.next = next;
        }

        @Override
        public void run() {
            try {
                // 计数器为0，则可执行，否则线程被阻塞
                current.await();
                System.out.println("thread start：" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 计数器减1，将计数器变为0，通知等待线程尝试获取锁执行
                next.countDown();
            }
        }
    }
}
