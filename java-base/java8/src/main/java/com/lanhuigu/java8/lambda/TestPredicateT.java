package com.lanhuigu.java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.lambda
 * @Author yihonglei
 * @date 2018/3/5 11:55
 */
public class TestPredicateT {
    public static void main(String[] args) {
        /** 封装List */
        List<Apple> appleList = new ArrayList<>();

        Apple apple1 = new Apple();
        apple1.setColor("red");
        apple1.setWeight(1.2);
        appleList.add(apple1);

        Apple apple2 = new Apple();
        apple2.setColor("yellow");
        apple2.setWeight(1.2);
        appleList.add(apple2);

        List<Apple> redApples = filter(appleList, (Apple apple) -> "red".equals(apple.getColor()));

        /** 循环打印过滤后的集合 */
        redApples.forEach((Apple apple) -> {
            System.out.println("apple.color:" + apple.getColor());
            System.out.println("apple.weight:" + apple.getWeight());
        });
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }

        return result;
    }
}
