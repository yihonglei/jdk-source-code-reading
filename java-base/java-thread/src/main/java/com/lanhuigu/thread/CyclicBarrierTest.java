package com.lanhuigu.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: CyclicBarrierTest
 * @Package: com.lanhuigu.thread
 * @date 2018/7/24 23:39
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                c.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();

        try {
            c.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
