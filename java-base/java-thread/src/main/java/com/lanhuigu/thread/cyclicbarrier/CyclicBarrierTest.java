package com.lanhuigu.thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier实例演示
 * @author yihonglei
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
