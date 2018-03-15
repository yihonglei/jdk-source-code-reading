package com.lanhuigu.java8.defaultmethod;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.defaultmethod
 * @date 2018/3/14 14:55
 */
public class DefaultTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 7);

        numbers.sort(Comparator.naturalOrder());
    }
}
