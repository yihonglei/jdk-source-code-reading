package com.lanhuigu.reflect.constructors;

import com.lanhuigu.reflect.cls.MyObject;

import java.lang.reflect.Constructor;

public class Test1 {
    public static void main(String[] args) {
        Class myClass = MyObject.class;
        Constructor[] constructors = myClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("constructor name:" + constructor.getName());
        }
    }
}
