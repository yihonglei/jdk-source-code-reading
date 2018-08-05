package com.lanhuigu.thread.createthread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: MyCallable
 * @Package: com.lanhuigu.thread.createthread
 * @date 2018/8/5 13:14
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
