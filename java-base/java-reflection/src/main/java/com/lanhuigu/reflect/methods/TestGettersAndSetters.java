package com.lanhuigu.reflect.methods;

import com.lanhuigu.reflect.common.MyObject;

import java.lang.reflect.Method;

public class TestGettersAndSetters {
    public static void main(String[] args) {
        /** 获取Class对象 */
        Class myClass = MyObject.class;

        /** 获取方法数组 */
        Method[] methods = myClass.getMethods();

        /** 循环判断get和set */
        for (Method method : methods) {
            if (isGetter(method)) {
                System.out.println("getter method name:" + method.getName());
            }

            if (isSetter(method)) {
                System.out.println("setter method name:" + method.getName());
            }
        }
    }

    /**
     * 判断是否是Getter方法：
     * 1. 以get开头
     * 2. 无参数
     * 3. 有一个返回值
     * @param method
     * @return
     */
    public static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) {
            return false;
        }

        if (method.getParameterTypes().length != 0) {
            return false;
        }

        if (void.class.equals(method.getReturnType())) {
            return false;
        }

        return true;
    }

    /**
     * 判断是否是Setter方法:
     * 1. 以set开头
     * 2. 只有一个方法参数
     * @param method
     * @return
     */
    public static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) {
            return false;
        }

        if (method.getParameterTypes().length != 1) {
            return false;
        }

        return true;
    }
}
