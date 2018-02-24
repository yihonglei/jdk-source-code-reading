package com.lanhuigu.reflect.methods;

import com.lanhuigu.reflect.common.MyObject;

import java.lang.reflect.Method;

public class Test3 {
    public static void main(String[] args) throws NoSuchMethodException {
        /** 获取Class对象 */
        Class myClass = MyObject.class;

        /** 指定方法参数获取方法 */
        Method method = myClass.getMethod("doSomething", new Class[]{String.class});

        /** 打印方法名 */
        System.out.println("方法名:" + method.getName());
    }
}
