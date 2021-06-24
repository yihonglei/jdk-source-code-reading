package com.jpeony.reflect.classname;

import com.jpeony.reflect.cls.MyObject;

/**
 * 通过getName()方法返回类的全限定类名（包含包名）：
 * Class myClass = ... //获取Class对象，参考上面的Class对象获取的三种方法
 * String className = myClass.getName();
 */
public class Test1 {
    public static void main(String[] args) {
        Class myClass = MyObject.class;
        String className = myClass.getName();
        System.out.println("className:" + className);
    }
}