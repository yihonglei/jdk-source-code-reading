package com.lanhuigu.jvm.loadclass;

/**
 * @author yihonglei
 * @date 2019/4/7 10:17
 */
public class JDKClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(JDKClassLoaderTest.class.getClassLoader().getClass().getName());
        System.out.println(ClassLoader.getSystemClassLoader().getClass().getName());
    }
}
