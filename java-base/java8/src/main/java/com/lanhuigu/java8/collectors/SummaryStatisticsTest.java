package com.lanhuigu.java8.collectors;

import com.lanhuigu.java8.stream.Dish;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.collectors
 * @date 2018/3/11 11:28
 */
public class SummaryStatisticsTest {
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

        IntSummaryStatistics menuStatistics =
                menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));

        System.out.println("max:" + menuStatistics.getMax());
        System.out.println("min:" + menuStatistics.getMin());
        System.out.println("count:" + menuStatistics.getCount());
        System.out.println("average:" + menuStatistics.getAverage());
        System.out.println("sum:" + menuStatistics.getSum());
    }
}
