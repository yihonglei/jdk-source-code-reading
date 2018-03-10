package com.lanhuigu.java8.stream;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.stream
 * @date 2018/3/10 11:45
 */
public class StreamMaxTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        Optional<Integer> max = list.stream().reduce(Integer::max);
        System.out.println(max.get());
    }
}
