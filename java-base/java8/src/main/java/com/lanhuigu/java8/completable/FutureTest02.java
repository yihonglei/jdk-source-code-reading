package com.lanhuigu.java8.completable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.completable
 * @date 2018/3/15 20:28
 */
public class FutureTest02 {
    public static void main(String[] args) {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = ((System.nanoTime() - start) / 1_1000_000);
        System.out.println("Invocation returned after" + invocationTime + "msecs");

        //
        try {
            double price = futurePrice.get();
            System.out.println("Price is " + price);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
