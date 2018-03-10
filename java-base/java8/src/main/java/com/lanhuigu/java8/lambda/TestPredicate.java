package com.lanhuigu.java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @ClassName: TestPredicate
 * @Package: com.lanhuigu.java8.lambda
 * @Author yihonglei
 * @date 2018/3/5 11:27
 * @version 1.0.0
 */
public class TestPredicate {
    public static void main(String[] args) {
        /** 封装List */
        List<Apple> appleList = new ArrayList<>();

        Apple apple1 = new Apple();
        apple1.setColor("green");
        apple1.setWeight(300);
        appleList.add(apple1);

        Apple apple2 = new Apple();
        apple2.setColor("yellow");
        apple2.setWeight(200);
        appleList.add(apple2);

        prettyPrintApple(appleList, new AppleFancyFormatter());
    }

    public static void prettyPrintApple(List<Apple> apples, AppleFormatter formatter) {
        for (Apple apple : apples) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }
}
