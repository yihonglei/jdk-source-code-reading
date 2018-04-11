package com.lanhuigu.others.init;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: InitialValues
 * @Package: com.lanhuigu.others.init
 * @date 2018/3/30 16:24
 */
public class InitialValues {
    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitialValues reference;

    void printInitialValues() {
        System.out.println("Data type Initial Value");
        System.out.println("boolean:" + t);
        System.out.println("char:" + t);
        System.out.println("byte:" + c);
        System.out.println("short:" + s);
        System.out.println("int:" + i);
        System.out.println("long:" + l);
        System.out.println("float:" + f);
        System.out.println("double:" + d);
        System.out.println("reference:" + reference);
    }

    public static void main(String[] args) {
        InitialValues iv = new InitialValues();
        iv.printInitialValues();
    }
}
