package com.jpeony.concurrent.threadorder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newSingleThreadExecutor()：线程池只有一个工作线程，工作线程从BlockingQueue阻塞有序队列取任务执行，
 * 从而保证线程的顺序性执行。
 */
public class NewSingleThreadExecutorOrder {
    public static void main(String[] args) {
        // 单个线程池，保证线程依次执行顺序
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // 创建线程
        Thread t1 = new Thread(new Work("one"));
        Thread t2 = new Thread(new Work("two"));
        Thread t3 = new Thread(new Work("three"));

        // 提交线程池
        executorService.submit(t1);
        executorService.submit(t2);
        executorService.submit(t3);

        // 关闭线程池
        executorService.shutdown();
    }

    static class Work implements Runnable {
        private String orderName;

        Work(String orderName) {
            this.orderName = orderName;
        }

        @Override
        public void run() {
            System.out.println("thread start：" + orderName);
        }
    }
}
