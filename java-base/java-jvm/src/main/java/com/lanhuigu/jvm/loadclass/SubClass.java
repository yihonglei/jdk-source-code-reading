package com.lanhuigu.jvm.loadclass;

/**
 * @author yihonglei
 * @ClassName: SubClass
 * @Package: com.lanhuigu.jvm.loadclass
 * @date 2018/4/29 22:07
 * @version 1.0.0
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}
