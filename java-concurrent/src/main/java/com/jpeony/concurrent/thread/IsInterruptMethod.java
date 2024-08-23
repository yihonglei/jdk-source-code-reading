package com.jpeony.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 判断线程是否已经中断，不清除线程的中断状态标识状态。
 */
public class IsInterruptMethod extends Thread {
    private final static Logger logger = LoggerFactory.getLogger(IsInterruptMethod.class);

    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("i = " + (i + 1));
        }
    }

    public static void main(String[] args) {
        try {
            IsInterruptMethod thread = new IsInterruptMethod();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            logger.info("是否停止1:{}", thread.isInterrupted());
            logger.info("是否停止2:{}", thread.isInterrupted());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
