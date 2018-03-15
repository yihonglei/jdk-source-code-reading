package com.lanhuigu.java8.collectors;

import java.util.Arrays;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.collectors
 * @date 2018/3/11 12:02
 */
public class Test {
    public static void main(String[] args) {
        String period = "1,2,3";
        int max = Arrays.stream(period.split(","))
                .mapToInt(str -> Integer.parseInt(str))
                .max()
                .getAsInt();

        System.out.println(max);
    }
}
