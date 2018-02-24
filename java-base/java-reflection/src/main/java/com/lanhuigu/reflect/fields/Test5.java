package com.lanhuigu.reflect.fields;

import com.lanhuigu.reflect.common.MyObject;

import java.lang.reflect.Field;

public class Test5 {
    public static void main(String[] args) {
        try {
            /** 获取Class对象 */
            Class myClass = Class.forName("com.lanhuigu.reflect.common.MyObject");
            /** 根据属性名获取Field */
            Field field = myClass.getField("fieldName");
            MyObject objectInstance = new MyObject();
            /** 通过get获取值 */
            Object value = field.get(objectInstance);
            System.out.println("Field.get()获取值:" + value.toString());
            /** 通过set设置值 */
            String fieldNameValue = "0000000000000000-new-value";
            field.set(objectInstance, fieldNameValue);
            /** 从新获取set进去的新值 */
            Object value2 = field.get(objectInstance);
            System.out.println("Field.get()获取Field.set()的新值:" + value2.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
