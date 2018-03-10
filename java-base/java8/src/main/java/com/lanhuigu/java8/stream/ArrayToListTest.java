package com.lanhuigu.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.stream
 * @date 2018/3/9 9:27
 */
public class ArrayToListTest {
    public static void main(String[] args) {
        String periods = "1,2";
        // ====
        /*int[] arrInt = Arrays.stream(periods.split(",")).mapToInt(str -> Integer.parseInt(str)).toArray();
        List<Integer> listStr = Arrays.stream(arrInt).boxed().collect(Collectors.toList());*/

        // ====
        List<String> listStr = Arrays.stream(periods.split(",")).collect(Collectors.toList());

        listStr.forEach(System.out::println);
    }
}
