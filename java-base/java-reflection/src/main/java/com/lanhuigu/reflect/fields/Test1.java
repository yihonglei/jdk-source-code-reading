package com.lanhuigu.reflect.fields;

import com.lanhuigu.reflect.cls.MyObject;

import java.lang.reflect.Field;

public class Test1 {
    public static void main(String[] args) {
        Class myClass = MyObject.class;
        /** 返回公有变量集合 */
        Field[] fields = myClass.getFields();
        for (Field field : fields) {
            System.out.println("field name:" + field.getName());
        }
    }
}
