package com.lanhuigu.jvm.loadclass;

/**
 * 子类
 *
 * @author yihonglei
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}
