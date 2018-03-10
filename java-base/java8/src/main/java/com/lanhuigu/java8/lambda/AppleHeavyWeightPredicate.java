package com.lanhuigu.java8.lambda;

/**
 *
 * @ClassName: AppleHeavyWeightPredicate
 * @Package: com.lanhuigu.java8.lambda
 * @Author yihonglei
 * @date 2018/3/5 10:46
 * @version 1.0.0
 */
public class AppleHeavyWeightPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
