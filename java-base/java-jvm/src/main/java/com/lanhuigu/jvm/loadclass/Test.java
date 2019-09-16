package com.lanhuigu.jvm.loadclass;


public class Test {
    static {
        // 给变量赋值可以正常编译通过
        int i = 0;
        // 输出语句编译器会提示"非法向前引用"
        System.out.println(i);
    }

    static int i = 1;

    public static void main(String[] args) {

    }
}
