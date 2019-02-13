package com.lanhuigu.thread.others;

/**
 * 串行和并发执行做同样事情，谁快谁慢这个是未知的，需要视情况而定。
 * 通俗点来说，有时候人多把事情办杂了。
 *
 * @author yihonglei
 * @date 2019/2/13 09:42
 */
public class ConcurrencyTest {
    private static final long count = 100001;

    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });

        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }

        thread.join();

        long time = System.currentTimeMillis() - start;

        System.out.println("concurrency：" + time + "ms");
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i ++) {
            a += 5;
        }

        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("serial：" + time + "ms");
    }

}
