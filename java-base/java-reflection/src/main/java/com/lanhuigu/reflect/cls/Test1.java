package com.lanhuigu.reflect.cls;

import java.lang.reflect.Method;

/**
 * 如果能够new某个对象，可以通过如下方式获取Class对象:
 * MyObject myObject = new MyObject();
 * Class myObjectClass = myObject.getClass();
 */
public class Test1 {
    public static void main(String[] args) {
        /** 获取Class对象 */
        MyObject myObject = new MyObject();
        Class myObjectClass = myObject.getClass();

        /** 获取Method */
        Method[] methods = myObjectClass.getMethods();

        /** 打印Method名称 */
        for (Method myMethod : methods) {
            System.out.println("MyObject中的方法名:" + myMethod.getName());
        }
    }
}
