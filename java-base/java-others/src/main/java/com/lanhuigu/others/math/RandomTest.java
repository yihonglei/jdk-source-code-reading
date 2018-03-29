package com.lanhuigu.others.math;

import java.util.Random;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: RandomTest
 * @Package: com.lanhuigu.others.math
 * @date 2018/3/27 8:49
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random(47);
        System.out.println(random.nextInt(100));
    }
}
