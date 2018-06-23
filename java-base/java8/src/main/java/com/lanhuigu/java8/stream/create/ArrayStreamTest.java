package com.lanhuigu.java8.stream.create;

import java.util.Arrays;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: ArrayStreamTest
 * @Package: com.lanhuigu.java8.stream.create
 * @date 2018/6/16 16:35
 */
public class ArrayStreamTest {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = Arrays.stream(numbers).sum();
        System.out.println("求和:" + sum);
    }
}
