package com.lanhuigu.java8.stream.create;

import java.util.stream.Stream;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: CreateStream
 * @Package: com.lanhuigu.java8.stream
 * @date 2018/6/16 16:14
 */
public class CreateStream {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("玩转Java", "玩转MySQL", "玩转Linux", "玩转Python");
        stream.map(String::toUpperCase).forEach(System.out::println);
    }
}
