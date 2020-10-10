package com.jpeony.concurrent.threadorder;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture顺序执行任务
 *
 * @author yihonglei
 */
public class CompletableFutureOrder {
    public static void main(String[] args) {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread-1");
            return "one";
        });

        cf.thenRun(() -> {
            System.out.println("Thread-2");
        });

        cf.thenRun(() -> {
            System.out.println("Thread-3");
        });
    }
}
