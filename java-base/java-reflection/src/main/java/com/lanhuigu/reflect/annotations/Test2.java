package com.lanhuigu.reflect.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws NoSuchMethodException {
        /** 获取Class对象 */
        Class myClass = TheClass2.class;

        /** 获取Method */
        Method method = myClass.getMethod("doSomething", new Class[]{String.class});

        /** 获取方法参数注解、Method对应的参数列表 */
        Annotation[][] paramterAnnotations = method.getParameterAnnotations();
        Class[] parameterTypes = method.getParameterTypes();

        for (int i = 0; i < paramterAnnotations.length; i++) {
            Annotation[] annotations = paramterAnnotations[i];
            Class parameterType = parameterTypes[i++];
            for(Annotation annotation : annotations){
                if(annotation instanceof MyAnnotation2){
                    MyAnnotation2 myAnnotation = (MyAnnotation2) annotation;
                    System.out.println("param: " + parameterType.getName());
                    System.out.println("name : " + myAnnotation.name());
                    System.out.println("value: " + myAnnotation.value());
                }
            }

        }
    }
}
