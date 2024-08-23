package com.jpeony.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Run {
    private final static Logger logger = LoggerFactory.getLogger(Run.class);

    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        logger.info("是否停止1:{}", Thread.interrupted());
        logger.info("是否停止2:{}", Thread.interrupted());
        logger.info("线程执行结束！");
    }
}
