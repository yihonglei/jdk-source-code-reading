package com.jpeony.jvm.statics;

/**
 * 方法静态变量解析

 */
public class StaticResolution {
    public static void sayHello() {
        System.out.printf("Hello World");
    }
    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
    public String hello(String name) {
        return "hello";
    }
}
