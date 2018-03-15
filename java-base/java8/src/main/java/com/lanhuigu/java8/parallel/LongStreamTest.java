package com.lanhuigu.java8.parallel;

import java.util.stream.LongStream;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.parallel
 * @date 2018/3/11 17:35
 */
public class LongStreamTest {
    public static void main(String[] args) {
        long sum = parallelRangedSum(10);
        System.out.println(sum);
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }
}
