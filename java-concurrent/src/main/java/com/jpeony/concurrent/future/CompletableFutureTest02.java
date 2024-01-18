package com.jpeony.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("begin");
        CompletableFuture<String> future = new CompletableFuture<>();

        new Thread(() -> {
            System.out.println("child-thread 任务执行......");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            future.complete("child-thread 任务完成返回结果");
        }).start();
        System.out.println("main-thread 等待子线程返回结果");
        System.out.println("main-thread 获取子线程返回结果 = " + future.get());
        System.out.println("end");
    }
}
