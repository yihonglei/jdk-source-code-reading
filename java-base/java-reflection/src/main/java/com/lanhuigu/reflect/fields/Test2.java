package com.lanhuigu.reflect.fields;

import java.lang.reflect.Field;

public class Test2 {
    public static void main(String[] args) {
        try {
            /** 获取Class对象 */
            Class myClass = Class.forName("com.lanhuigu.reflect.common.MyObject");
            /** 获取对象所有公开（public）属性 */
            Field[] fields = myClass.getFields();
            /** 循环输出变量名称 */
            for (Field field : fields) {
                System.out.println(field.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
