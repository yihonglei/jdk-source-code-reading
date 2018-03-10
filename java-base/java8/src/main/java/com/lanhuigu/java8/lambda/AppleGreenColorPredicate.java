package com.lanhuigu.java8.lambda;

/**
 *
 * @ClassName: AppleGreenColorPredicate
 * @Package: com.lanhuigu.java8.lambda
 * @Author yihonglei
 * @date 2018/3/5 10:49
 * @version 1.0.0
 */
public class AppleGreenColorPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
