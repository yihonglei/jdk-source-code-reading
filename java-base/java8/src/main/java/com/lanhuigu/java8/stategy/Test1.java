package com.lanhuigu.java8.stategy;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.stategy
 * @date 2018/3/12 14:16
 */
public class Test1 {
    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaa");
        System.out.println("isNumeric:" + b1);

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");
        System.out.println("isAllLowerCase:" + b2);
    }
}
