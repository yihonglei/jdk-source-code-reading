package com.lanhuigu.java8.completable;

import java.util.concurrent.*;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.completable
 * @date 2018/3/15 20:00
 */
public class Shop {
    private String product;
    private String name;
    private ExecutorService executorService = Executors.newFixedThreadPool(100);

    public Shop (String name) {
        this.name = name;
    }

    /** 阻塞调用方法 */
    public double getPrice(String product) {
        /** 随机生成一个值 */
        return calculatePrice(product);
    }
    /** 非阻塞调用方法 */
    public Future<Double> getPriceAsync(String product) {
        /** 通过new创建CompletableFuture对象 */
        /*CompletableFuture<Double> futurePrice = new CompletableFuture<>();
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                futurePrice.complete(price);
            } catch (Exception ex) {
                futurePrice.completeExceptionally(ex);
            }
        }).start();

        return futurePrice;*/

        /** 通过工厂方法创建CompletableFuture对象 */
        return CompletableFuture.supplyAsync(() -> calculatePrice(product), executorService);
    }

    private double calculatePrice(String product) {
        /** 模拟1秒钟的延迟 */
        delay();
        return ThreadLocalRandom.current().nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
