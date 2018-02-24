package com.lanhuigu.reflect.generics;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test3 {
    public static void main(String[] args) throws NoSuchFieldException {
        /** 获取Class对象 */
        Class myClass = MyClass.class;

        /** 获取Field对象 */
        Field field = myClass.getField("stringList");

        /** 获取属性泛型 */
        Type genericFieldType = field.getGenericType();
        if (genericFieldType instanceof ParameterizedType) {
            ParameterizedType aType = (ParameterizedType) genericFieldType;
            Type[] fieldArgTypes = aType.getActualTypeArguments();
            for (Type fieldArgType : fieldArgTypes) {
                Class fieldArgClass = (Class) fieldArgType;
                System.out.println("fieldArgClass = " + fieldArgClass);
            }
        }
    }
}
