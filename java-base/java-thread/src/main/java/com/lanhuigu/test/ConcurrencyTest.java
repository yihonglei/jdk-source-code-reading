package com.lanhuigu.test;

/**
 * 并发效率测试
 *
 * @author yihonglei
 * @date 2019/3/18 07:46
 */
public class ConcurrencyTest {
    private static final long count = 100000000000L;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });

        t.start();

        int b = 0;
        for (long i = 0; i < count; i++) {
            b --;
        }

        Thread.sleep(100000000);
        t.join();

        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency: " + time + "ms");
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }

        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("serial: " + time + "ms");
    }
}
