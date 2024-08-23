package com.jpeony.concurrent.threadlocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadA extends Thread {
    private final static Logger logger = LoggerFactory.getLogger(ThreadA.class);

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                DataTools.THREAD_LOCAL.set("A_Thread_" + System.currentTimeMillis());
                // 获取当前线程私有数据
                logger.info("线程A获取的值:{}", DataTools.THREAD_LOCAL.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException ex) {
            logger.error("ThreadA执行异常!", ex);
        }
    }
}
