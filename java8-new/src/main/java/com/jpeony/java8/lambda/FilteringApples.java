package com.jpeony.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println("greenApples:" + greenApples);

        List<Apple> greenApplesTwo = filterApplesByColor(inventory, "green");
        System.out.println("greenApplesTwo:" + greenApplesTwo);

        List<Apple> heavyApples = filterApplesByWeight(inventory, 100);
        System.out.println("heavyApples:" + heavyApples);
    }

    /**
     * 筛选绿苹果
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 根据颜色筛选苹果
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 根据重量筛选苹果
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

}
