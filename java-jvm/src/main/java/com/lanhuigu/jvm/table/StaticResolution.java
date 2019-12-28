package com.lanhuigu.jvm.table;

/**
 * @author yihonglei
 */
public class StaticResolution {
    public static void sayHello() {
        System.out.println("hello world!");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
}
