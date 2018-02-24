package com.lanhuigu.reflect.constructors;

import com.lanhuigu.reflect.common.MyObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test5 {
    public static void main(String[] args) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        /** 根据参数类型获取构造器 */
        Constructor constructor = MyObject.class.getConstructor(new Class[]{String.class});
        /** 根据构造器动态创建对象实例 */
        MyObject myObject = (MyObject) constructor.newInstance("hello world");
        /** 调用对象中属性的getter方法 */
        System.out.println("userName:" + myObject.getUserName());
    }
}
