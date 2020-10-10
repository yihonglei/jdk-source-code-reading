package com.jpeony.concurrent.future;

import com.jpeony.concurrent.util.SleepUtils;

import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture简单Demo
 *
 * @author yihonglei
 */
public class CompletableFutureSimple {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.supplyAsync(() -> {
            System.out.println("师傅准备做蛋糕");
            SleepUtils.second(3);
            System.out.println("师傅做好蛋糕了");
            return "cake";
        }).thenAccept(cake -> {
            System.out.println("我吃蛋糕:" + cake);
        });

        System.out.println("我先去喝杯牛奶");
        Thread.currentThread().join();
    }
}
