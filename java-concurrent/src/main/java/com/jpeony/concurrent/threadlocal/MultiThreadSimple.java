package com.jpeony.concurrent.threadlocal;

/**
 * ThreadLocal线程隔离，线程内的ThreadLocal相互隔离。
 */
public class MultiThreadSimple {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Work1(), "Thread-1");
        Thread t2 = new Thread(new Work2(), "Thread-2");

        t1.start();
        t2.start();

        Thread.currentThread().join();
    }

    static class Work1 implements Runnable {
        @Override
        public void run() {
            // 当前线程创建17个ThreadLocal
            for (int i = 1; i < 18; i++) {
                ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();
                THREAD_LOCAL.set("ThreadLocal-Thread1-" + i);
                System.out.println(THREAD_LOCAL.get());
            }
        }
    }

    static class Work2 implements Runnable {
        private ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

        @Override
        public void run() {
            THREAD_LOCAL.set("ThreadLocal-Thread2");
            System.out.println(THREAD_LOCAL.get());
        }
    }
}
