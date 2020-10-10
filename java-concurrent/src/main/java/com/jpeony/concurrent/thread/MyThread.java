package com.jpeony.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通过继承Thread类，重写run方法，创建线程
 *
 * @author yihonglei
 */
public class MyThread extends Thread {
    private final static Logger logger = LoggerFactory.getLogger(MyThread.class);

    @Override
    public void run() {
        logger.info("通过继承Thread创建线程");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        logger.info("多线程技术--代码运行结果与代码执行顺序或调用顺序无关");
    }
}
