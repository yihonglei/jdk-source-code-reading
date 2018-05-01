package com.lanhuigu.jvm.loadclass;

/**
 * @author yihonglei
 * @ClassName: SuperClass
 * @Package: com.lanhuigu.jvm.loadclass
 * @date 2018/4/29 22:06
 * @version 1.0.0
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}
