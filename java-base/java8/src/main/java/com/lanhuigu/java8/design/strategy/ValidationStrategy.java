package com.lanhuigu.java8.design.strategy;

/**
 * 算法族
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: ValidationStrategy
 * @Package: com.lanhuigu.java8.design.strategy
 * @date 2018/6/29 11:25
 */
@FunctionalInterface
public interface ValidationStrategy {
    boolean execute(String s);
}
