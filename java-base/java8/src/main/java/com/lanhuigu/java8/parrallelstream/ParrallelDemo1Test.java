package com.lanhuigu.java8.parrallelstream;

import java.util.stream.Stream;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: ParrallelDemo1Test
 * @Package: com.lanhuigu.java8.parrallelstream
 * @date 2018/6/16 17:31
 */
public class ParrallelDemo1Test {
    public static void main(String[] args) {
        System.out.println(parallelSum(10));
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }
}
