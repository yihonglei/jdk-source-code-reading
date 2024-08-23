package com.jpeony.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable，有返回值
 */
public class MyCallable implements Callable<String> {
    private final static Logger logger = LoggerFactory.getLogger(MyCallable.class);

    @Override
    public String call() {
        return "test Callable";
    }

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        try {
            new Thread(futureTask).start();
            String s = futureTask.get();
            logger.info("Callable返回值:{}", s);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
