package com.jpeony.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 模拟 rocketmq 同步发送消息
 */
public class CompletableFutureTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("begin");
        // 发送消息
        CompletableFuture<String> future = new CompletableFuture<>();
        System.out.println("消息发送成功");

        // 等着子线程回调
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("回调");
            future.complete("");
        });
        t.start();

        // 主线程同步等待回调返回结果
        System.out.println("同步阻塞等待结果，回调唤醒继续执行");
        CompletableFuture<String> futureb = future.whenComplete((a, e) -> {
            System.out.println("one");
        });
        futureb.thenApply(String::length).get();

        System.out.println("end");
    }
}
