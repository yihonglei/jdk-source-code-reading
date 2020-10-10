package com.jpeony.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取线程id
 *
 * @author yihonglei
 */
public class GetIdMethod extends Thread {
    private final static Logger logger = LoggerFactory.getLogger(GetIdMethod.class);

    @Override
    public void run() {
        logger.info("线程ID={}", Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        GetIdMethod getIdThread = new GetIdMethod();
        getIdThread.start();
    }
}
