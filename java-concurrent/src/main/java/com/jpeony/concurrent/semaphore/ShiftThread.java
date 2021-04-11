package com.jpeony.concurrent.semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 大便！
 *
 * @author yihonglei
 */
public class ShiftThread extends Thread {
    private final static Logger logger = LoggerFactory.getLogger(ShiftThread.class);

    private Toilet toilet;
    private Integer num;

    public ShiftThread(Toilet toilet, Integer num) {
        this.toilet = toilet;
        this.num = num;
    }

    @Override
    public void run() {
        try {
            // 获得坑
            Toilet.Pit pitAcquire = toilet.getPit();
            logger.info("序号:{}, 描述:{}", num, pitAcquire.getDesc());
            // 解决大号
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.error("Semaphore测试异常!", e);
        } finally {
            // 释放坑
            Toilet.Pit release = toilet.releasePit();
            logger.info("序号:{}, 描述:{}", num, release.getDesc());
        }
    }
}
