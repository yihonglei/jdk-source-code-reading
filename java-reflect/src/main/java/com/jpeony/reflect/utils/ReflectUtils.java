package com.jpeony.reflect.utils;

import java.lang.reflect.Field;

/**
 * 反射工具（能不用反射，尽量不要用反射）
 *
 * @author yihonglei
 */
public class ReflectUtils {
    /**
     * 获取对象属性集合
     *
     * @author yihonglei
     */
    public static String[] getFileNames(Object object) {
        try {
            Field[] fields = object.getClass().getDeclaredFields();
            String[] fileNames = new String[fields.length];
            for (int i = 0; i < fields.length; i++) {
                fileNames[i] = fields[i].getName();
            }
            return fileNames;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据对象属性名，获取属性值
     *
     * @author yihonglei
     */
    public static Object getFieldValueByFieldName(String fieldName, Object object) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
