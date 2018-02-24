package com.lanhuigu.reflect.interfaces;

import com.lanhuigu.reflect.cls.MyObject;

public class Test1 {
    public static void main(String[] args) {
        Class myClass = MyObject.class;
        Class[] interfaces = myClass.getInterfaces();
        for (Class c : interfaces) {
            System.out.println("interfaces name:" + c.getName());
        }
    }
}
