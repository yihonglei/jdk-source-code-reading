package com.jpeony.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异常法：判断线程中断状态为true时，抛线程中断异常。
 */
public class ExceptionMethod extends Thread {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionMethod.class);

    @Override
    public void run() {
        try {
            for (int i = 0; i < 500000; i++) {
                // 判断线程是否中断
                if (interrupted()) {
                    logger.info("线程已经停止，退出代码执行");
                    throw new InterruptedException();
                }
                System.out.println("i = " + (i + 1));
            }
            logger.info("跳出for循环，执行for循环后的代码");
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        try {
            ExceptionMethod exceptionMethod = new ExceptionMethod();
            exceptionMethod.start();

            Thread.sleep(1000);
            exceptionMethod.interrupt();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
