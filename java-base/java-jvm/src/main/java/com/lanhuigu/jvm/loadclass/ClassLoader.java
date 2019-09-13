package com.lanhuigu.jvm.loadclass;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器与instanceof关键字演示
 * @author yihonglei
 * @date 2018/4/29 22:33
 */
public class ClassLoader {
    public static void main(String[] args) throws Exception {
        java.lang.ClassLoader myLoader = new java.lang.ClassLoader() {
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

        Object obj = myLoader.loadClass("com.lanhuigu.jvm.loadclass.ClassLoader").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoader);
    }
}
