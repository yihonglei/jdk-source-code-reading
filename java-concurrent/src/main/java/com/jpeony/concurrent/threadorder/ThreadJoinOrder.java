package com.jpeony.concurrent.threadorder;

/**
 * join控制线程顺序执行
 *
 * @author yihonglei
 */
public class ThreadJoinOrder {
    public static void main(String[] args) throws InterruptedException {
        // 创建线程
        Thread t1 = new Thread(new Work(), "Thread-1");
        Thread t2 = new Thread(new Work(), "Thread-2");
        Thread t3 = new Thread(new Work(), "Thread-3");

        // 调用join
        t1.join();
        t2.join();
        t3.join();

        // 启动线程
        t1.start();
        t2.start();
        t3.start();
    }

    static class Work implements Runnable {
        @Override
        public void run() {
            System.out.println("thread start：" + Thread.currentThread().getName());
        }
    }
}
