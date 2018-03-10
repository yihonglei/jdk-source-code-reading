package com.lanhuigu.java8.real;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

/**
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.real
 * @Author yihonglei
 * @date 2018/3/7 9:43
 */
public class Test {
    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();
        a1.setColor("green");
        a1.setWeight("333");
        appleList.add(a1);

        Supplier<Apple> c2 = Apple::new;
        Apple a2 = c2.get();
        a2.setColor("yellow");
        a2.setWeight("222");
        appleList.add(a2);

        /** 1.代码传递 */
        /*appleList.forEach(apple -> {
            System.out.println(apple.getColor());
            System.out.println(apple.getWeight());
        });

        appleList.sort(new AppleComparator());

        appleList.forEach(apple -> {
            System.out.println(apple.getColor());
            System.out.println(apple.getWeight());
        });*/

        /** 2.匿名类 */
        /*appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
        appleList.forEach(apple -> {
            System.out.println(apple.getColor());
            System.out.println(apple.getWeight());
        });*/

        /** lambda表达式 */
        appleList.sort(Comparator.comparing(Apple::getWeight));
        appleList.forEach(apple -> {
            System.out.println(apple.getColor());
            System.out.println(apple.getWeight());
        });

    }
}
