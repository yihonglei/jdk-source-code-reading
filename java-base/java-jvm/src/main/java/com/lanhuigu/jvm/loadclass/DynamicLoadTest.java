package com.lanhuigu.jvm.loadclass;

/**
 * VM Args：-verbose:class
 * 打印类加载详细信息。
 */
public class DynamicLoadTest {
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
