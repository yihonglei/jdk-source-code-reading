package com.jpeony.annotation.demo2;

import java.lang.annotation.*;

/**
 * 注解类
 *
 * @author yihonglei
 */
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target({ElementType.FIELD, ElementType.METHOD}) // 定义注解的作用目标**作用范围字段、枚举的常量/方法
@Documented // 说明该注解将被包含在javadoc中
public @interface FieldMeta {
    /**
     * 是否为序列号
     */
    boolean id() default false;
    /**
     * 字段名称
     */
    String name() default "";
    /**
     * 字段描述
     */
    String description() default "";
    /**
     * 排序字段
     */
    int order() default 0;
}
