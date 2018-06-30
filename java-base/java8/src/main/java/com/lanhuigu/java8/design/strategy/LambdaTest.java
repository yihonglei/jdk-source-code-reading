package com.lanhuigu.java8.design.strategy;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: LambdaTest
 * @Package: com.lanhuigu.java8.design.strategy
 * @date 2018/6/29 11:39
 */
public class LambdaTest {
    public static void main(String[] args) {
        Validator numericValidator =
                new Validator((String s) -> s.matches("[a-z]+"));
        boolean b1 = numericValidator.validate("aaaa");
        System.out.println(b1);

        Validator lowerCaseValidator =
                new Validator((String s) -> s.matches("\\d+"));
        boolean b2 = lowerCaseValidator.validate("bbbb");
        System.out.println(b2);
    }
}
