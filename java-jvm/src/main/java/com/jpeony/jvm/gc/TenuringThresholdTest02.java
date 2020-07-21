package com.jpeony.jvm.gc;

/**
 * VM参数:
 * -verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
 *
 * 参数说明:
 * -verbose:gc 输出显示虚拟机运行信息；
 *
 * -XX:+PrintGCDetails 打印内存回收日志；
 *
 * -Xms20M -Xmx20M -Xmn10M 限制堆大小为20M，不可以扩展，10M分配给新生代，剩下10分配给老年代；
 *
 * -XX:SurvivorRatio=8 配置Eden区与一个Survivor区的比例，这里是默认的8:1，不用显示配置也可以；
 *
 * -XX:MaxTenuringThreshold=1 年龄阀值设置，默认为15岁。
 *
 *
 * 程序说明:
 * 从结果可以看出eden使用51%，from、to两个Survivor未使用，老年代使用了52%。
 *
 * allocation1、allocation2、allocation3分配进入Eden区。
 *
 * 当第一次给allocation4分配内存时，eden区内存不够，发生一次Minor GC，
 *
 * 此时allocation1、allocation2将会进入survivor区，而allocation3通过担保机制将会进入老年代。
 *
 * 第二次发生在给allocation4分配内存时，此时，survivor区的allocation1、allocation2达到了survivor区容量的一半，
 *
 * 将会进入老年代，此次GC可以清理出allocation4原来的4MB空间，并将allocation4分配在Eden区。
 *
 * 最终，allocation1、allocation2、allocation3在老年代，allocation4在Eden区。
 *
 * @author yihongeli
 */
public class TenuringThresholdTest02 {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }
}
