package com.lanhuigu.jvm.loadclass;

/**
 * @author yihonglei
 * @ClassName: ConstClass
 * @Package: com.lanhuigu.jvm.loadclass
 * @date 2018/4/29 22:33
 * @version 1.0.0
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORD = "Hello World";
}
