package com.lanhuigu.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: CountDownLatchTest
 * @Package: com.lanhuigu.thread
 * @date 2018/7/24 23:36
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();

        c.await();
    }
}
