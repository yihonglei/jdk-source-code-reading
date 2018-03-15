package com.lanhuigu.java8.stategy;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.stategy
 * @date 2018/3/12 14:19
 */
public class TestLambda {
    public static void main(String[] args) {
        Validator numericValidator = new Validator((String s) -> s.matches("[a-z]+"));
        boolean b1 = numericValidator.validate("aaa");
        System.out.println("isNumeric:" + b1);

        Validator lowerCaseValidator = new Validator((String s) -> s.matches("\\d+"));
        boolean b2 = lowerCaseValidator.validate("bbbb");
        System.out.println("lowerCase:" + b2);
    }
}
