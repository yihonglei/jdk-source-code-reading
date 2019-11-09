package com.lanhuigu.jvm.loadclass;

/**
 * 子类
 * @author yihonglei
 * @date 2018/4/29 22:07
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}
