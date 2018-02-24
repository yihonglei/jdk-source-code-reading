package com.lanhuigu.reflect.methods;

import com.lanhuigu.reflect.common.MyObject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test6 {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        /** 获取Class对象 */
        Class myClass = MyObject.class;

        /** 获取Method对象 */
        Method method = myClass.getMethod("doSomething", new Class[]{String.class});

        /** 方法调用 */
        MyObject myObject = new MyObject();
        Object returnValue = method.invoke(myObject, "parameter-value1");

        System.out.println("调用方法返回值:" + returnValue.toString());
    }
}
