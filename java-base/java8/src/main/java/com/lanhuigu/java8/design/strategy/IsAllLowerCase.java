package com.lanhuigu.java8.design.strategy;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: IsAllLowerCase
 * @Package: com.lanhuigu.java8.design.strategy
 * @date 2018/6/29 11:25
 */
public class IsAllLowerCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}
