package com.lanhuigu.reflect.arrays;

public class Test2 {
    public static void main(String[] args) {
        String[] strings = new String[3];
        Class stringArrayClass = strings.getClass();
        Class stringArrayComponentType = stringArrayClass.getComponentType();
        System.out.println(stringArrayComponentType);
    }
}
