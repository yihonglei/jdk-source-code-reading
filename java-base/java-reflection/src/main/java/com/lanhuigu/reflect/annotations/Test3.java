package com.lanhuigu.reflect.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Test3 {
    public static void main(String[] args) throws NoSuchFieldException {
        /** 获取Class对象 */
        Class myClass = TheClass3.class;

        /** 获取Field` */
        Field field = myClass.getField("myField");

        /** 获取属性注解方式1 */
        Annotation[] annotations = field.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation3) {
                MyAnnotation3 myAnnotation = (MyAnnotation3) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }
        }
        System.out.println("=================================================");
        /** 获取属性注解方式2 */
        Annotation annotation = field.getAnnotation(MyAnnotation3.class);
        if (annotation instanceof MyAnnotation3) {
            MyAnnotation3 myAnnotation = (MyAnnotation3) annotation;
            System.out.println("name: " + myAnnotation.name());
            System.out.println("value: " + myAnnotation.value());
        }
    }
}
