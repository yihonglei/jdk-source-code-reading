package com.lanhuigu.reflect.generics;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test1 {
    public static void main(String[] args) throws NoSuchMethodException {
        /** 获取Class对象 */
        Class myClass = MyClass.class;

        /** 获取Method对象 */
        Method method = myClass.getMethod("getStringList", null);

        /** 获取方法返回泛型 */
        Type returnType = method.getGenericReturnType();
        if (returnType instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();
            for (Type typeArgument : typeArguments) {
                Class typeArgClass = (Class) typeArgument;
                System.out.println("typeArgClass = " + typeArgClass);
            }
        }
    }
}
