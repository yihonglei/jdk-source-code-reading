package com.jpeony.concurrent.future;

import lombok.val;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

/**
 * CompletableFuture创建方式
 *
 * @author yihonglei
 */
public class CompletableFutureCreate {
    public static void main(String[] args) {
        // 直接创建
        CompletableFuture c0 = new CompletableFuture();
        // 直接创建一个已经做完的蛋糕
        val c1 = CompletableFuture.completedFuture("cake");
        // 无返回值异步任务，会采用内部forkjoin线程池
        val c2 = CompletableFuture.runAsync(() -> {});
        // 无返回值异步任务，采用定制的线程池
        val c3 = CompletableFuture.runAsync(() -> {}, Executors.newSingleThreadExecutor());
        // 返回值异步任务，采用定制的线程池
        val c4 = CompletableFuture.supplyAsync(() -> "cake", Executors.newSingleThreadExecutor());
        // 返回值异步任务，采用内部forkjoin线程池
        val c5 = CompletableFuture.supplyAsync(() -> "cake");
        // 只要有一个完成，则完成，有一个抛异常，则携带异常
        CompletableFuture.anyOf(c1, c2, c3, c4, c5);
        // 当所有的 future 完成时,新的 future 同时完成
        // 当某个方法出现了异常时,新 future 会在所有 future 完成的时候完成,并且包含一个异常.
        CompletableFuture.allOf(c1, c2, c3, c4, c5);
    }
}
