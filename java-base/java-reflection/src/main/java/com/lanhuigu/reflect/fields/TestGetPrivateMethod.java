package com.lanhuigu.reflect.fields;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestGetPrivateMethod {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /** 创建对象 */
        PrivateObject privateObject = new PrivateObject("The Private Value");

        /** 获取对象的私有方法 */
        Method privateStringMethod = PrivateObject.class.getDeclaredMethod("getPrivateString", null);
        privateStringMethod.setAccessible(true);

        /** 方法调用，并打印方法返回结果 */
        String returnValue = (String)privateStringMethod.invoke(privateObject, null);
        System.out.println("returnValue = " + returnValue);
    }
}
