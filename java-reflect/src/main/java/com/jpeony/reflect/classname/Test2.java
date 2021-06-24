package com.jpeony.reflect.classname;

import com.jpeony.reflect.cls.MyObject;

/**
 * 如果你仅仅只是想获取类的名字(不包含包名)，那么你可以使用getSimpleName()方法:
 * Class myClass = ... //获取Class对象，参考上面的Class对象获取的三种方法
 * String simpleClassName = myClass.getSimpleName();
 */
public class Test2 {
    public static void main(String[] args) {
        Class myClass = MyObject.class;
        String simpleClassName = myClass.getSimpleName();
        System.out.println("simpleClassName:" + simpleClassName);
    }
}