package com.lanhuigu.java8.stategy;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.stategy
 * @date 2018/3/12 14:14
 */
public class Validator {
    private final ValidationStrategy stategy;


    public Validator(ValidationStrategy v) {
        this.stategy = v;
    }

    public boolean validate(String s) {
        return stategy.execute(s);
    }

}
