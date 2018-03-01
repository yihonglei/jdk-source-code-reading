package com.lanhuigu.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestLambda {
    public static void main(String[] args) {
        /** 封装List */
        List<Apple> appleList = new ArrayList<>();

        Apple apple1 = new Apple();
        apple1.setColor("green");
        apple1.setWeight(1.2);
        appleList.add(apple1);

        Apple apple2 = new Apple();
        apple2.setColor("yellow");
        apple2.setWeight(1.2);
        appleList.add(apple2);

        /** 过滤List */
        List<Apple> apples = appleList.stream().filter((Apple a) -> "green".equals(a.getColor())).collect(Collectors.toList());
        //apples.removeAll(apples);
        /** 循环打印过滤后的集合 */
        apples.forEach((Apple apple) -> {
            System.out.println("apple.color:" + apple.getColor());
            System.out.println("apple.weight:" + apple.getWeight());
        });

    }
}
