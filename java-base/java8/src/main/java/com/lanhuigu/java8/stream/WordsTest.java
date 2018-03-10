package com.lanhuigu.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.stream
 * @date 2018/3/10 9:25
 */
public class WordsTest {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");

        List<String> filters =
                words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        filters.forEach(System.out::print);
    }
}
