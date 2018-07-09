package com.lanhuigu.jvm.gc;

/**
 * VM Args: -XX:+PrintGCDetails
 * 参数描述: 用于打印GC日志，可以指定GC文件目录-XX:+PrintGCDetails -Xloggc:d:\gc.log
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _MB = 1024 * 1024;
    private byte[] bigSize = new byte[2 * _MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance  = objA;

        objA = null;
        objB = null;

        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
