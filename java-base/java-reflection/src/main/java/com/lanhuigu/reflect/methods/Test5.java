package com.lanhuigu.reflect.methods;

import com.lanhuigu.reflect.common.MyObject;

import java.lang.reflect.Method;

public class Test5 {
    public static void main(String[] args) throws NoSuchMethodException {
        /** 获取Class对象 */
        Class myClass = MyObject.class;

        /** 获取Method */
        Method method = myClass.getMethod("doSomething", new Class[]{String.class});

        /** 获取参数返回值类型 */
        Class returnType = method.getReturnType();
        System.out.println("方法返回值类型:" + returnType.getName());
    }
}
