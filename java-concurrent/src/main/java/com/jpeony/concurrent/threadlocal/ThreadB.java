package com.jpeony.concurrent.threadlocal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yihonglei
 */
public class ThreadB extends Thread {
    private final static Logger logger = LoggerFactory.getLogger(ThreadB.class);

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                DataTools.THREAD_LOCAL.set("B_Thread_" + System.currentTimeMillis());
                // 获取当前线程私有数据
                logger.info("线程Ｂ获取的值：{}", DataTools.THREAD_LOCAL.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException ex) {
            logger.error("ThreadB执行异常!", ex);
        }
    }
}
