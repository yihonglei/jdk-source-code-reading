package com.lanhuigu.jvm.loadclass;

import java.io.IOException;
import java.io.InputStream;

/**
 * 定义一个简单类加载器:
 * 不同类加载器加载出来的对象，是不同的对象。
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }

                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        Object obj = myLoader.loadClass("com.lanhuigu.jvm.loadclass.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        /**
         * obj为自定义类加载器加载，而com.lanhuigu.jvm.loadclass.ClassLoaderTest为JVM类加载器加载，
         * 是两个不同的类加载器加载，所以是不同的对象。
         *
         * 检查结果返回: false
         */
        System.out.println(obj instanceof com.lanhuigu.jvm.loadclass.ClassLoaderTest);
    }

}
