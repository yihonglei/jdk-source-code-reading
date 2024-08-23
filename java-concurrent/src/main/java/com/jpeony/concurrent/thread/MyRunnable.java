package com.jpeony.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通过实现Runnable接口，实现run方法，创建线程
 */
public class MyRunnable implements Runnable {
    private final static Logger logger = LoggerFactory.getLogger(MyRunnable.class);

    @Override
    public void run() {
        logger.info("通过实现Runnable接口创建线程");
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        logger.info("多线程技术--代码运行结果与代码执行顺序或调用顺序无关");
    }
}
