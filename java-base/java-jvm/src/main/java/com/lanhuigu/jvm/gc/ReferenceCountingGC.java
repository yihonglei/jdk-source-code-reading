package com.lanhuigu.jvm.gc;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+PrintGCDetails
 * 参数描述: 用于打印GC日志，可以指定GC文件目录-XX:+PrintGCDetails -Xloggc:/Users/hongqi/gc.log
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _MB = 1024 * 1024;
    /**
     * 这个成员属性的唯一意义就是占点内存，以便在GC日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * _MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        try {
            Thread.sleep(1000 * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 告诉jvm，希望进行一次垃圾回收
        System.gc();

//        try {
//            Thread.sleep(1000 * 600);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        testGC();
    }
}
