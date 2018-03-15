package com.lanhuigu.java8.ex;

import java.util.stream.Stream;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.ex
 * @date 2018/3/10 22:41
 */
public class TestNoStream {
    public static void main(String[] args) {
        Stream.iterate(0, n -> n+2)
                .limit(10)
                .forEach(System.out::print);
    }
}
