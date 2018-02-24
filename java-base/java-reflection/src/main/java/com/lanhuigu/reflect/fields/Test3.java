package com.lanhuigu.reflect.fields;

import java.lang.reflect.Field;

public class Test3 {
    public static void main(String[] args) {
        try {
            /** 获取Class对象 */
            Class myClass = Class.forName("com.lanhuigu.reflect.common.MyObject");
            /** 根据属性名获取Field */
            Field field = myClass.getField("fieldName");
            /** 输出变量名称 */
            System.out.println(field.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
