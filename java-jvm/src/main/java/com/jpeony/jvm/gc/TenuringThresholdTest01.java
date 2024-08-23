package com.jpeony.jvm.gc;

/**
 * JVM 参数配置:
 * -verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+UseSerialGC -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
* JVM 参数说明:
 * -verbose:gc 输出显示虚拟机运行信息；
 * -XX:+PrintGCDetails 打印内存回收日志；
 * -Xms20M -Xmx20M -Xmn10M 限制堆大小为20M，不可以扩展，10M 分配给新生代，剩下 10M 分配给老年代；
 * -XX:SurvivorRatio=8 配置Eden区与一个Survivor区的比例，这里是默认的8:1，不用显示配置也可以；
 * -XX:MaxTenuringThreshold=1 年龄阀值设置，默认为15岁。
* 程序说明:
 * 从执行结果可以看出 eden 使用 51%，from、to 两个 Survivor 区未使用，老年代使用 50%。
 * 按照程序内存分配，从上到下分析，allocation1 分配 _1MB/4 进入 eden 区，allocation2 分配 4MB 进入 eden 区，
 * 当第一次分配 allocation3 时，发现 eden 区内存不够，直接触发 Minor GC，allocation1 和 allocation2 按理说都进入
 * Survivor 区，但是 Survivor 区只有 1MB，只能容得下 allocation1，allocation1 进入 Survivor 区并且年龄为 1，
 * 将在下一次 GC 时晋升到老年代，而 allocation2 通过担保机制直接进入老年代，allocation3 分配 4MB 则在 eden 区。
 * 当第二次分配 allocation3 时，分配 4M，这样 eden 区不够，因为上一次分配 allocation3 是 4MB，要比实际大，
 * 现在又来 4M，eden 区只有 8MB，当然 eden 区内存就不够了，这个时候又触发了一次 Minor GC，allocation1 年龄加 1，
 * 晋升到老年代，allocation2 也还在老年代，上一次的 allocation3 因为被设置为 null，直接被清除，eden 区变为 8MB 内存，
 * 第二次的 allocation3 被分配到 eden 区。
 * 最终结果就是：allocation1, allocation2 分配在老年区，allocation3 分配在新生代的 eden 区。
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
