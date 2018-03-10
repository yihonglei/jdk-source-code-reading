package com.lanhuigu.java8.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.stream
 * @date 2018/3/9 10:44
 */
public class MaxTest {
    public static void main(String[] args) {
        String periods = "1,2";
        int[] arrInt = Arrays.stream(periods.split(",")).mapToInt(str -> Integer.parseInt(str)).toArray();
        int maxPeriod = IntStream.of(arrInt).max().getAsInt();

        System.out.println("maxPeriod:" + maxPeriod);
    }
}
