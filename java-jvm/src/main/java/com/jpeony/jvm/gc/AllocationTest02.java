package com.jpeony.jvm.gc;

/**
 * 【分配的内存 >=Eden 大小的一半，就直接放入了老年代】
 * JVM 参数配置: -verbose:gc -XX:+PrintGCDetails -Xmx20M -Xms20M -Xmn10M -XX:SurvivorRatio=8
 * JVM 参数说明:
 * -verbose:gc 输出显示虚拟机运行信息；
 * -XX:+PrintGCDetails 打印内存回收日志；
 * -Xmx20M -Xms20M -Xmn10M 限制堆大小为 20M，不可以扩展，10M 分配给新生代，剩下 10M 分配给老年代；
 * -XX:SurvivorRatio=8 配置 Eden 区与一个 Survivor 区的比例，这里是默认的8:1，不用显示配置也可以；
 *
 * @author yihonglei
 */
public class AllocationTest02 {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1 = new byte[2 * _1MB];
        byte[] allocation2 = new byte[2 * _1MB];
        byte[] allocation3 = new byte[5 * _1MB];
    }
}
