package com.lanhuigu.thread.concurrent;

/**
 * @author yihonglei
 * @date 2019/11/3 8:55 PM
 */
public class ConcurrentTest {
    private static final long COUNT = 10001;

    public static void main(String[] args) throws InterruptedException {
        // 并行
        concurrency();
        // 串行
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < COUNT; i++) {
                    a += 5;
                }
            }
        });

        thread.start();

        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }

        thread.join();

        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency:" + time + "ms, b=" + b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < COUNT; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < COUNT; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms, b=" + b + ", a=" + a);
    }
}
