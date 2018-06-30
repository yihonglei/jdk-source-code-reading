package com.lanhuigu.java8.design.strategy;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Test
 * @Package: com.lanhuigu.java8.design.strategy
 * @date 2018/6/29 11:28
 */
public class Test {
    public static void main(String[] args) {
        Validator numericVAlidator = new Validator(new IsNumeric());
        boolean b1 = numericVAlidator.validate("aaaa");
        System.out.println(b1);

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");
        System.out.println(b2);
    }
}
