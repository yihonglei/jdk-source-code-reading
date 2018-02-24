package com.lanhuigu.reflect.methods;

import com.lanhuigu.reflect.common.MyObject;

import java.lang.reflect.Method;

public class Test4 {
    public static void main(String[] args) throws NoSuchMethodException {
        /** 获取Class对象 */
        Class myClass = MyObject.class;

        /** 获取Method */
        Method method = myClass.getMethod("doSomething", new Class[]{String.class});

        /** 获取参数类型数组 */
        Class[] parameterTypes = method.getParameterTypes();

        /** 循环打印参数类型 */
        for (Class type : parameterTypes) {
            System.out.println("参数类型:" + type.getName());
        }
    }
}
