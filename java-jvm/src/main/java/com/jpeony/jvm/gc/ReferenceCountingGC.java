package com.jpeony.jvm.gc;

/**
 * JVM 参数配置:
 * -Xms20m -Xmx20m -XX:+PrintGCDetails -Xloggc:/Users/hongqi/gc.log
 *
 * JVM 参数说明：
 * -Xms20m -Xmx20m 堆最大最小设置为 20M，限制堆内存大小为 20M
 * -XX:+PrintGCDetails 用于打印 GC 日志
 * -Xloggc:/Users/hongqi/gc.log 输出 GC 日志到指定目录
 *
 * @author yihonglei
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _MB = 1024 * 1024;
    /**
     * 这个成员属性的唯一意义就是占点内存，以便在 GC 日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * _MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        // 告诉jvm，希望进行一次垃圾回收
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
