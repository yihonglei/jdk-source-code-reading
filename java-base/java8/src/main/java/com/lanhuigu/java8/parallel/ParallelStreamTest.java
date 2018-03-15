package com.lanhuigu.java8.parallel;

import java.util.stream.Stream;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.parallel
 * @date 2018/3/11 17:21
 */
public class ParallelStreamTest {
    public static void main(String[] args) {
        long sum = parallelSum(10);
        System.out.println(sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i +1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }
}
