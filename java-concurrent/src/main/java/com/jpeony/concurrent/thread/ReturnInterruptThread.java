package com.jpeony.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * return停止：方法中的代码遇到return时，该方法运行结束，利用这种手段，也能达到线程停止的效果。
 *
 * @author yihonglei
 */
public class ReturnInterruptThread extends Thread {
    private final static Logger logger = LoggerFactory.getLogger(ReturnInterruptThread.class);

    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            if (interrupted()) {
                logger.info("通过return，实现线程停止效果!");
                return;
            }
            System.out.println(" i = " + (i + 1));
        }
    }

    public static void main(String[] args) {
        try {
            ReturnInterruptThread returnThread = new ReturnInterruptThread();
            returnThread.start();

            Thread.sleep(2000);
            returnThread.interrupt();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
