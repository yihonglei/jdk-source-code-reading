package com.lanhuigu.java8.real;

import java.util.Comparator;

/**
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.real
 * @Author yihonglei
 * @date 2018/3/7 9:39
 */
public class AppleComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
    }
}
