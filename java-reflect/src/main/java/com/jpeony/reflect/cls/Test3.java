package com.jpeony.reflect.cls;

import java.lang.reflect.Method;

/**
 * 如果你在编译期不知道类的名字，但是你可以在运行期获得到类名的字符串,那么你则可以这么做来获取Class对象:
 * String className = ... ; //在运行期获取的类名字符串
 * Class class = Class.forName(className);
 * <p>
 * 在使用Class.forName()方法时，你必须提供一个类的全名，这个全名包括类所在的包的名字。
 * 例如MyObject类位于com.lanhuigu.reflect.cls包，那么他的全名就是com.lanhuigu.reflect.cls.MyObject。
 * 如果在调用Class.forName()方法时，没有在编译路径下(classpath)找到对应的类，那么将会抛出ClassNotFoundException。
 */
public class Test3 {
    public static void main(String[] args) {
        try {
            /* 获取Class对象 */
            String className = "com.lanhuigu.reflect.cls.MyObject";
            Class myObjectClass = Class.forName(className);

            /* 获取Method */
            Method[] methods = myObjectClass.getMethods();

            /* 打印Method名称 */
            for (Method myMethod : methods) {
                System.out.println("MyObject中的方法名:" + myMethod.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
