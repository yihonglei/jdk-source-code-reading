package com.jpeony.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 判断当前线程是否已经中断，同时执行结束时清除线程状态并将线程状态标识为默认状态false。
 *
 * @author yihonglei
 */
public class InterruptedMethod extends Thread {
    private final static Logger logger = LoggerFactory.getLogger(InterruptedMethod.class);

    @Override
    public void run() {
        // 循环50万次
        for (int i = 0; i < 500000; i++) {
            System.out.println("i = " + (i + 1));
        }
    }

    public static void main(String[] args) {
        try {
            InterruptedMethod thread = new InterruptedMethod();
            // 启动InterruptMethod线程
            thread.start();
            // main线程休眠2秒
            Thread.sleep(2000);
            // 调用interrupt中断线程
            thread.interrupt();
            // 判断是否已经中断
            logger.info("是否停止1:{}", interrupted());
            // 判断是否已经中断
            logger.info("是否停止2:{}", interrupted());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
