package com.jpeony.jvm.gc;

/**
 * VM参数:
 * -verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+HandlePromotionFailure
 *
 * 程序说明：
 * 一开始allocation1、allocation2、allocation3分配在eden区，同时allocation1被置为无效。
 *
 * 当第一次给allocation4分配内存时，eden区内存不够，发生一次Minor GC，
 *
 * 由于老年代的连续可用空间大于存活的对象总和，所以allocation2、allocation3将会进入老年代，
 *
 * allocation1的空间将被回收，此时整个eden区被清空，又变为8MB，有空间让allocation4分配在eden区；
 *
 * 接下来allocation5、allocation6接着往eden区分配，同时allocation4、allocation5、allocation6被置为无效。
 *
 * 当第二次给allocation7分配内存时，eden区内存不够，发生一次Minor GC，allocation4、allocation5、
 *
 * allocation6所占的内存全部回收，把整个eden区清空，变为8MB，然后将allocation7分配在新生代eden区。
 *
 * 最后，allocation2、allocation3在老年代，allocation7在新生代。
 *
 * @author yihongeli
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
