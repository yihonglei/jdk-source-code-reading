package com.jpeony.reflect.cls;

import java.lang.reflect.Method;

/**
 * 如果你在编译期知道一个类的名字的话，那么你可以使用如下的方式获取一个类的Class对象:
 * Class myObjectClass = MyObject.class;
 */
public class Test2 {
    public static void main(String[] args) {
        /* 获取Class对象 */
        Class myObjectClass = MyObject.class;

        /* 获取Method */
        Method[] methods = myObjectClass.getMethods();

        /* 打印Method名称 */
        for (Method myMethod : methods) {
            System.out.println("MyObject中的方法名:" + myMethod.getName());
        }
    }
}