package com.lanhuigu.queue;

import java.util.concurrent.CountDownLatch;

public class TestHarness {
    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        // 起始门
        final CountDownLatch startGate = new CountDownLatch(1);
        // 结束门
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        /** 所有线程创建之后都在启动门上等待，await方法表示在计数器不为0时，会一直阻塞到计数器为0 */
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            /** 没执行一次，计数器减少1 */
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {

                    }
                }
            };
        }

        long startTime = System.nanoTime();
        /** 将起始门的闭锁计数器清零，让之前被阻塞在起始门的的线程开始执行 */
        startGate.countDown();
        /** 只有当结束门计数器为0时，才不会阻塞，程序才会往下执行，也即保证所有线程都执行完时，程序才往下执行 */
        endGate.await();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
