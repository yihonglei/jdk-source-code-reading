package com.lanhuigu.java8.design.strategy;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: IsNumeric
 * @Package: com.lanhuigu.java8.design.strategy
 * @date 2018/6/29 11:26
 */
public class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}
