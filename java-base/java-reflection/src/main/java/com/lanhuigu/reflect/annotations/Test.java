package com.lanhuigu.reflect.annotations;

import com.lanhuigu.reflect.cls.MyObject;

import java.lang.annotation.Annotation;

/**
 * 获取类注解
 */
public class Test {
    public static void main(String[] args) {
        /** 获取Class对象 */
        Class myClass = TheClass.class;

        /** 访问类注解方式1 */
        /*Annotation[] annotations = myClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("myAnnotation name:" + myAnnotation.name());
                System.out.println("myAnnotation value:" + myAnnotation.value());
            }
        }*/

        /** 访问类注解方式2 */
        Annotation annotation = myClass.getAnnotation(MyAnnotation.class);
        if (annotation instanceof MyAnnotation) {
            MyAnnotation myAnnotation = (MyAnnotation) annotation;
            System.out.println("myAnnotation name:" + myAnnotation.name());
            System.out.println("myAnnotation value:" + myAnnotation.value());
        }
    }
}
