package com.jpeony.jvm.loadclass;

/**
 * 动态类加载！
 * VM Args：-verbose:class 打印类加载过程详细信息。
 */
public class DynamicLoad {
    static {
        System.out.println("******static code******");
    }

    public static void main(String[] args) {
        new A();
        System.out.println("******load test******");
        new B();
    }
}

class A {
    public A() {
        System.out.println("******A code******");
    }
}

class B {
    public B() {
        System.out.println("******B code******");
    }
}
