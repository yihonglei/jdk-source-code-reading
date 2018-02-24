package com.lanhuigu.reflect.constructors;

import com.lanhuigu.reflect.common.MyObject;

import java.lang.reflect.Constructor;

public class Test3 {
    public static void main(String[] args) throws NoSuchMethodException {
        Class myClass = MyObject.class;
        Constructor constructor = myClass.getConstructor(new Class[]{String.class});
    }
}
