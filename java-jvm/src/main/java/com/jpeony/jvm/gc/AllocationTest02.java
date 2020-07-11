package com.jpeony.jvm.gc;

/**
 * VM参数: -verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
 *
 * 参数说明:
 * -verbose:gc 输出显示虚拟机运行信息；
 *
 * -XX:+PrintGCDetails 打印内存回收日志
 *
 * -Xms20M -Xmx20M -Xmn10M 限制堆大小为20M，不可以扩展，10M分配给新生代，剩下10分配给老年代
 *
 * -XX:SurvivorRatio=8 配置Eden区与一个Survivor区的比例，这里是默认的8:1，不用显示配置也可以；
 *
 * 程序说明:
 * 程序执行后，eden区用了75%，from 未占用，to未占用，而ParOldGen老年代占用50%。
 * 当allocation1，allocation2分配的时候，eden区占用75%，咱们分配4M，实际占用了6M，
 * 这个时候再分配allocation3是5M，eden区剩余内存不够5M，然后allocation3直接分配在老年代，
 * 因为分配的内存>=Eden大小的一半，就直接放入了老年代。
 */
public class AllocationTest02 {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1 = new byte[2 * _1MB];
        byte[] allocation2 = new byte[2 * _1MB];
        byte[] allocation3 = new byte[5 * _1MB];
    }
}
