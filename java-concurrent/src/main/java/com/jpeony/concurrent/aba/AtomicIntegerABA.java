package com.jpeony.concurrent.aba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ABA问题演示
 *
 * @author yihonglei
 */
public class AtomicIntegerABA {
    private final static Logger logger = LoggerFactory.getLogger(AtomicIntegerABA.class);
    private static AtomicInteger atomicInt = new AtomicInteger(18);

    public static void main(String[] args) throws InterruptedException {
        // 线程A 18-->38
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info("===ThreadA begin===");
                atomicInt.compareAndSet(18, 38);
                logger.info("===ThreadA end===");
            }
        });

        // 线程B 38-->18
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadA.join();
                    logger.info("===ThreadB begin===");
                    atomicInt.compareAndSet(38, 18);
                    logger.info("===ThreadB end===");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 线程C 18-->99
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    threadB.join();
                    logger.info("===ThreadC begin===");
                    boolean c = atomicInt.compareAndSet(18, 99);
                    logger.info("c={}", c);
                    logger.info("atomicInt.get()={}", atomicInt.get());
                    logger.info("===ThreadC end===");
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
