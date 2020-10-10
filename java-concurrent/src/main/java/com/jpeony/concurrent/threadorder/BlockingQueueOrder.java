package com.jpeony.concurrent.threadorder;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 通过阻塞队列+while循环控制线程的顺序性，或者通过ArrayList控制线程的顺序，但是需要在每个线程执行完成时自己从队列移出元素。
 *
 * @author yihonglei
 */
public class BlockingQueueOrder {
    public static void main(String[] args) throws InterruptedException {
        // 创建线程
        Thread t1 = new Thread(new Work(), "Thread-1");
        Thread t2 = new Thread(new Work(), "Thread-2");
        Thread t3 = new Thread(new Work(), "Thread-3");
        // 队列保证顺序性
        BlockingQueue<Thread> blockingQueue = new LinkedBlockingQueue<>();
        blockingQueue.add(t1);
        blockingQueue.add(t2);
        blockingQueue.add(t3);

        for (int i = 0; i < 3; i++) {
            Thread take = blockingQueue.take();
            take.start();
            while (take.isAlive()) ;
        }

        // 主线程保持存活
        Thread.sleep(3000);
    }

    static class Work implements Runnable {
        @Override
        public void run() {
            System.out.println("thread start：" + Thread.currentThread().getName());
        }
    }
}
