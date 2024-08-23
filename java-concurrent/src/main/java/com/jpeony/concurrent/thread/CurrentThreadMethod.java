package com.jpeony.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Thread类中的currentThread()方法，返回当前的线程对象
 */
public class CurrentThreadMethod extends Thread {
    private final static Logger logger = LoggerFactory.getLogger(CurrentThreadMethod.class);

    @Override
    public void run() {
        logger.info("ThreadName = {}", Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        CurrentThreadMethod currentThreadMethod = new CurrentThreadMethod();
        currentThreadMethod.start();
    }
}
