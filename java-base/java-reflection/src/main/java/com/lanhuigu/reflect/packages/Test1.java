package com.lanhuigu.reflect.packages;

import com.lanhuigu.reflect.cls.MyObject;

public class Test1 {
    public static void main(String[] args) {
        Class myClass = MyObject.class;
        Package packages = myClass.getPackage();
        System.out.println("packages.name:" + packages.getName());
    }
}
