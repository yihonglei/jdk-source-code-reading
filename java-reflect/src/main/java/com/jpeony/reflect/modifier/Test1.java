package com.jpeony.reflect.modifier;

import java.lang.reflect.Modifier;

public class Test1 {
    public static void main(String[] args) {
        try {
            Class myClass = Class.forName("com.lanhuigu.reflect.cls.MyObject");
            int modifiers = myClass.getModifiers();
            System.out.println("isPrivate:" + Modifier.isPrivate(modifiers));
            System.out.println("isPublic:" + Modifier.isPublic(modifiers));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}