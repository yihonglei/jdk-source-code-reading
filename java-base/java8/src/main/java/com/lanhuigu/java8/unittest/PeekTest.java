package com.lanhuigu.java8.unittest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.unittest
 * @date 2018/3/14 13:39
 */
public class PeekTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> result =
                numbers.stream()
                .peek(x -> System.out.println("from stream:" + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after stream:" + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter:" + x))
                .limit(3)
                .peek(x -> System.out.println("after limit:" + x))
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}
