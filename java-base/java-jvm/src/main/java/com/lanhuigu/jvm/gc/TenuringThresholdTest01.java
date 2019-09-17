package com.lanhuigu.jvm.gc;

/**
 * VM参数:
 * -verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
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
 * 从执行结果可以看出eden使用51%，from、to两个Survivor区未使用，老年代使用50%。
 * 按照程序内存分配，从上到下分析，allocation1分配_1MB/4进入eden区，allocation2分配4MB进入eden区，
 * 当第一次分配allocation3时，发现eden区内存不够，直接触发Minor GC，allocation1和allocation2按理说都进入
 * Survivor区，但是Survivor区只有1MB，只能容得下allocation1，allocation1进入Survivor区并且年龄为1，
 * 将在下一次GC时晋升到老年代，而allocation2通过担保机制直接进入老年代，allocation3分配4MB则在eden区。
 * 当第二次分配allocation3时，分配4M，这样eden区不够，因为上一次分配allocation3是4MB，要比实际大，
 * 现在又来4M，eden区只有8MB，当然eden区内存就不够了，这个时候又触发了一次Minor GC，allocation1年龄加1，
 * 晋升到老年代，allocation2也还在老年代，上一次的allocation3因为被设置为null，直接被清除，eden区变为8MB内存，
 * 第二次的allocation3被分配到eden区。
 * 最终结果就是：allocation1, allocation2分配在老年区，allocation3分配在新生代的eden区。
 */
public class TenuringThresholdTest01 {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }
}
