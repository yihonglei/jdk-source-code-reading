package com.lanhuigu.java8.stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: MenuTest
 * @Package: com.lanhuigu.java8.stream
 * @date 2018/6/12 19:57
 */
public class MenuTest {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Type.MEAT),
                new Dish("beef", false, 700, Type.MEAT),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("season fruit", true, 120, Type.OTHER),
                new Dish("pizza", true, 550, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("salmon", false, 450, Type.FISH) );

        List<String> threeHighCaloricDishNames =
                menu.stream()
                    .filter(d -> d.getCalories() > 300)
                    .map(Dish::getName)
                    .limit(3)
                    .collect(toList());

        System.out.println(threeHighCaloricDishNames);

        System.out.println("=====================================================");
        List<String> names =
                menu.stream()
                    .filter(d -> {
                        System.out.println("filtering" + d.getName());
                        return d.getCalories() > 300;
                    })
                    .map(d -> {
                        System.out.println("mapping" + d.getName());
                        return d.getName();
                    })
                    .limit(3)
                    .collect(toList());

        System.out.println(names);
    }
}
