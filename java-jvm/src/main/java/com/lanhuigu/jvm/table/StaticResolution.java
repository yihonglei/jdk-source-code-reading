package com.lanhuigu.jvm.table;

/**
 * @author yihonglei
 * @ClassName: StaticResolution
 * @Package: com.lanhuigu.jvm.table
 * @date 2018/5/1 15:17
 * @version 1.0.0
 */
public class StaticResolution {
    public static void sayHello() {
        System.out.println("hello world!");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
}
