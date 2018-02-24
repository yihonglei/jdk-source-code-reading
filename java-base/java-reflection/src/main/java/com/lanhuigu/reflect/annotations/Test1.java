package com.lanhuigu.reflect.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 获取方法注解
 */
public class Test1 {
    public static void main(String[] args) throws NoSuchMethodException {
        /** 获取Class对象 */
        Class myClass = TheClass1.class;
        /** 获取Method对象 */
        Method method = myClass.getMethod("doSomething", null);

        /** 获取方法注解方式1 */
        Annotation[] annotations = method.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation1) {
                MyAnnotation1 myAnnotation = (MyAnnotation1) annotation;
                System.out.println("myAnnotation1 name:" + myAnnotation.name());
                System.out.println("myAnnotation1 value:" + myAnnotation.value());
            }
        }
        /** 获取方法注解方式2 */
        Annotation annotation = method.getAnnotation(MyAnnotation1.class);
        if (annotation instanceof MyAnnotation1) {
            MyAnnotation1 myAnnotation = (MyAnnotation1) annotation;
            System.out.println("myAnnotation1 name:" + myAnnotation.name());
            System.out.println("myAnnotation1 value:" + myAnnotation.value());
        }
    }
}
