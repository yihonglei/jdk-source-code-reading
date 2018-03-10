package com.lanhuigu.java8.constructor;

import com.lanhuigu.java8.lambda.Apple;

import java.util.function.Supplier;

/**
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.constructor
 * @Author yihonglei
 * @date 2018/3/7 9:32
 */
public class Test {
    public static void main(String[] args) {
        Supplier<Apple> c1 = Apple::new;
        Apple apple = c1.get();
        apple.setColor("green");
        apple.setWeight(1);

        System.out.println(apple.getColor());
    }
}
