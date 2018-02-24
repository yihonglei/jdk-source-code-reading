package com.lanhuigu.reflect.methods;

import com.lanhuigu.reflect.cls.MyObject;

import java.lang.reflect.Method;

public class Test1 {
    public static void main(String[] args) {
        Class myClass = MyObject.class;
        Method[] methods = myClass.getMethods();
        for (Method method : methods) {
            System.out.println("method name:" + method.getName());
        }
    }
}
