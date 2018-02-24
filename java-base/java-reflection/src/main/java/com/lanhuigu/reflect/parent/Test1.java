package com.lanhuigu.reflect.parent;

import com.lanhuigu.reflect.cls.MyObject;

public class Test1 {
    public static void main(String[] args) {
        Class myClass = MyObject.class;
        Class superClass = myClass.getSuperclass();
        System.out.println("superClass name:" + superClass.getName());
    }
}
