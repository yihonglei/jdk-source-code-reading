package com.lanhuigu.jvm.loadclass;

public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}
