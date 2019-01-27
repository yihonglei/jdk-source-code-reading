package com.lanhuigu.thread.createthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable，返回值
 */
public class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        return "test Callable";
    }

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        try {
            new Thread(futureTask).start();
            String s = futureTask.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
