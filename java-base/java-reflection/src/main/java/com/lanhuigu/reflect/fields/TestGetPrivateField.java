package com.lanhuigu.reflect.fields;

import java.lang.reflect.Field;

public class TestGetPrivateField {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        /** 创建对象 */
        PrivateObject privateObject = new PrivateObject("The Private Value");

        /** 获取对象的私有变量 */
        Field privateStringField = PrivateObject.class.getDeclaredField("privateString");
        privateStringField.setAccessible(true);

        /** 获取私有变量的值 */
        String fieldValue = (String) privateStringField.get(privateObject);
        System.out.println("fieldValue = " + fieldValue);
    }
}
