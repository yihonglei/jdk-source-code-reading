package com.lanhuigu.java8.unittest;

import java.util.Arrays;
import java.util.List;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.unittest
 * @date 2018/3/14 13:19
 */
public class Debugging {
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(new Point(12, 2), null);

        points.stream().map(p -> p.getX()).forEach(System.out::println);
    }
}
