package com.lanhuigu.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.stream
 * @date 2018/3/8 9:42
 */
public class TestConsumerOnce {
    public static void main(String[] args) {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        /** 流和迭代器一样，只能遍历一次，也即只能消费一次，否则，Exception: stream has already been operated upon or closed */
        s.forEach(System.out::println);
    }
}
