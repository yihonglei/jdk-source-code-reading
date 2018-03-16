package com.lanhuigu.java8.completable;

import java.util.Arrays;
import java.util.List;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.completable
 * @date 2018/3/16 9:46
 */
public class FutureTest03 {
    public static void main(String[] args) {
        List<Shop> shops = Arrays.asList(
                new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));
    }
}
