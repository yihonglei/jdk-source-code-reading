package com.lanhuigu.jvm.loadclass;

/**
 * 非主动使用类字段演示
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
