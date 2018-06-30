package com.lanhuigu.java8.design.strategy;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Validator
 * @Package: com.lanhuigu.java8.design.strategy
 * @date 2018/6/29 11:27
 */
public class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy v) {
        this.strategy = v;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }

}
