package com.jpeony.jvm.loadclass;

/**
 * 被动使用类字段演示三：
 * 常量池在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。
 *
 * @author yihongeli
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORD = "Hello World";
}
