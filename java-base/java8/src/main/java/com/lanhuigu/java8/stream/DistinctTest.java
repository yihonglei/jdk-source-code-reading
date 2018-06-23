package com.lanhuigu.java8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: DistinctTest
 * @Package: com.lanhuigu.java8.stream
 * @date 2018/6/16 12:11
 */
public class DistinctTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 1, 4, 5, 6, 7, 7, 8);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }
}
