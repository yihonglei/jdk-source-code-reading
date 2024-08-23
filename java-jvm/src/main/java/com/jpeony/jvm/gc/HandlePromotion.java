package com.jpeony.jvm.gc;

/**
 * JVM 参数配置:
 * -verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+HandlePromotionFailure
* 程序说明：
 * 一开始 allocation1、allocation2、allocation3 分配在 eden 区，同时 allocation1 被置为无效。
 * 当第一次给 allocation4 分配内存时，eden 区内存不够，发生一次 Minor GC，
 * 由于老年代的连续可用空间大于存活的对象总和，所以 allocation2、allocation3 将会进入老年代，
 * allocation1 的空间将被回收，此时整个 eden 区被清空，又变为 8MB，有空间让 allocation4 分配在 eden 区；
 * 接下来 allocation5、allocation6 接着往 eden 区分配，同时 allocation4、allocation5、allocation6 被置为无效。
 * 当第二次给 allocation7 分配内存时，eden 区内存不够，发生一次 Minor GC，allocation4、allocation5、
 * allocation6 所占的内存全部回收，把整个 eden 区清空，变为 8MB，然后将 allocation7 分配在新生代 eden 区。
 * 最后，allocation2、allocation3 在老年代，allocation7 在新生代。
 */
public class HandlePromotion {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4,
                allocation5, allocation6, allocation7, allocation8;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }
}
