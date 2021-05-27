package com.jpeony.annotation.demo1;

import java.lang.annotation.*;

/**
 * @author yihonglei
 */
@Documented // 说明该注解将被包含在javadoc中
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target(ElementType.METHOD) // 定义注解的作用目标**作用范围字段、枚举的常量/方法
public @interface MyAnnotation {
    String value1() default "hello";

    MyEnum value2() default MyEnum.Sunny;

    String[] value3() default "hello Array";
}

enum MyEnum {
    Sunny, Rainy
}
