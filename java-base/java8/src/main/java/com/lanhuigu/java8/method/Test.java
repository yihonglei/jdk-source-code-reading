package com.lanhuigu.java8.method;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.method
 * @Author yihonglei
 * @date 2018/3/7 9:16
 */
public class Test {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.forEach(System.out::println);

        str.sort(String::compareToIgnoreCase);

        str.forEach(System.out::println);
    }
}
