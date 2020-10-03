package com.jpeony.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yihonglei
 */
public class ReflectionReaderTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        AnnotationTest annotationTest = new AnnotationTest();
        // 获取AnnotationTest的Class实例
        Class<AnnotationTest> c = AnnotationTest.class;
        // 获取需要处理的方法Method实例
        Method method = c.getMethod("execute", new Class[]{});
        // 判断该方法是否包含MyAnnotation注解
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            // 获取该方法的MyAnnotation注解实例
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            // 执行该方法
            method.invoke(annotationTest, new Object[]{});
            // 获取myAnnotation中value3变量，然后打印数组中元素
            String[] value3 = myAnnotation.value3();
            for (String v : value3) {
                System.out.println(v);
            }
        }
        // 获取方法上的所有注解
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}