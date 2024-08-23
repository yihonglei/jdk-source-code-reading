package com.jpeony.concurrent.synchronizeds.releases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用synchronized当出现异常时，锁会自动释放
 */
public class MyService {
    private final static Logger logger = LoggerFactory.getLogger(MyService.class);

    synchronized public void serviceMethod() {
        // 当前线程名称
        String threadName = Thread.currentThread().getName();

        if ("A".equals(threadName)) {
            logger.info("ThreadName = {}，begin time = {}", threadName, System.currentTimeMillis());
            // 制造异常: 当异常产生时，A线程释放锁，B线程活期锁，开始执行。
            Integer.parseInt("A");
        } else {
            try {
                Thread.sleep(2000);
                logger.info("Thread = {}，执行!", threadName);
            } catch (InterruptedException e) {
                logger.error("Thread = {}，执行异常!", threadName, e);
            }
        }
    }
}
