package com.jpeony.java8.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

/**
 * @author yihonglei
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
//        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(new CallImpl());
    }

    static class CallImpl implements Callable<Integer> {
        @Override
        public Integer call() {
            Random random = new Random(10);
            return random.nextInt();
        }
    }
}
