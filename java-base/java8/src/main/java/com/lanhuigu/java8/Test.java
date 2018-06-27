package com.lanhuigu.java8;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Demo01Test
 * @Package: com.lanhuigu.java8
 * @date 2018/5/28 16:39
 */
public class Test {
    public static void main(String[] args) {
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                                        .filter(n -> n % 2 == 0);

        System.out.println(evenNumbers.count());
    }
}
