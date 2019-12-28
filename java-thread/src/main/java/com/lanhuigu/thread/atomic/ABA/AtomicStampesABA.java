package com.lanhuigu.thread.atomic.ABA;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 增加标记，解决ABA问题
 *
 * @author yihonglei
 *  2019/2/17 10:39
 */
public class AtomicStampesABA {
    private static AtomicStampedReference atomicStampedRef = new AtomicStampedReference(18,0);

    public static void main(String[] args) throws InterruptedException {
        // 线程A 18-->38(18-0 --> 38-1)
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("===ThreadA begin===");
                atomicStampedRef.compareAndSet(18, 38, atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
                System.out.println("===ThreadA end===");
            }
        });

        // 线程B 38-->18(38-1 --> 18-2)
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadA.join();
                    System.out.println("===ThreadB begin===");
                    atomicStampedRef.compareAndSet(38, 18, atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
                    System.out.println("===ThreadB end===");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 线程C 18-->99(18-0 --> 99-1，但是atomicStampedRef里面现在的18是18-2，多以更新失败，18已经不是初始化时的18了)
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadB.join();
                    System.out.println("===ThreadC begin===");
                    boolean c = atomicStampedRef.compareAndSet(18, 99, 0, 1);
                    System.out.println(c);
                    System.out.println("===ThreadC end===");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

        threadC.join();
    }
}
