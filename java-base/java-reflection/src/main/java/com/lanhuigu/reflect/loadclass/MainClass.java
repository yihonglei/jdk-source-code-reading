package com.lanhuigu.reflect.loadclass;

public class MainClass {
    public static void main(String[] args){
        ClassLoader classLoader = MainClass.class.getClassLoader();
        try {
            Class myClass = classLoader.loadClass("com.lanhuigu.reflect.loadclass.MyClass");
            System.out.println("myClass.getName() = " + myClass.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
