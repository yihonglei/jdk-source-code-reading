package com.lanhuigu.reflect.methods;

import com.lanhuigu.reflect.common.MyObject;

import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) {
        /** 获取Class对象 */
        Class myClass = MyObject.class;

        /** 获取公开(public)方法集合 */
        Method[] methods = myClass.getMethods();

        /** 循环打印方法名 */
        for (Method method : methods) {
            System.out.println("方法名:" + method.getName());
        }
    }
}
