package com.lanhuigu.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName:
 * @Package: com.lanhuigu.java8.stream
 * @date 2018/3/8 9:01
 */
public class StreamMapTest {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        List<Integer> lowCaloricDishesName =
                menu.stream() // 1. 流查询
                .map(Dish::getName)// 2. 形成一条流水线
                .map(String::length)
                .collect(Collectors.toList());// 3. 执行流水线，返回结果

        lowCaloricDishesName.forEach(System.out::println);
    }
}
