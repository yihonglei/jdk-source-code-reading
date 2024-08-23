package com.jpeony.jvm.table;


public class StaticResolution {
    public static void sayHello() {
        System.out.println("hello world!");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
}
