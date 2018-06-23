package com.lanhuigu.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: OnceConsumer
 * @Package: com.lanhuigu.java8.stream
 * @date 2018/6/15 16:55
 */
public class OnceConsumer {
    public static void main(String[] args) {
        List<String> title = Arrays.asList("one", "two", "three");
        Stream<String> s = title.stream();
        /* 流只能消费一次 **/
        s.forEach(System.out::println);
        /* 如果再次消费，报异常（stream has already been operated upon or closed） **/
        s.forEach(System.out::println);
    }
}
