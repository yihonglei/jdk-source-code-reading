package com.lanhuigu.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 测试
 */
public class LambdaFilterTest {
    private static List<Apple> initApples() {
        Apple apple1 = new Apple();
        apple1.setColor("red");
        apple1.setWeight(12.5);

        Apple apple2 = new Apple();
        apple2.setColor("green");
        apple2.setWeight(100.4);

        List<Apple> apples = new ArrayList<>();
        apples.add(apple1);
        apples.add(apple2);

        return apples;
    }

    public static void main(String[] args) {
        /** 筛选红苹果 */
        List<Apple> redApples =
                initApples().stream().filter(apple -> "red".equals(apple.getColor())).collect(Collectors.toList());
        /** 打印 */
        redApples.stream().forEach(apple -> System.out.println(apple.getColor()));
    }
}
