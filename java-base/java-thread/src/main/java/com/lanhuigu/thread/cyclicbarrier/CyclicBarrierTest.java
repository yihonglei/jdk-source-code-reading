package com.lanhuigu.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier实例演示
 *
 * @author yihonglei
 * @date 2018/7/24 23:39
 */
public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(3);

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        new Thread(() -> {
            try {
                c.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();

        new Thread(() -> {
            try {
                c.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(2);
        }).start();

        c.await();
    }
}
