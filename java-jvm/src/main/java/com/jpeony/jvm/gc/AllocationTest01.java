package com.jpeony.jvm.gc;

/**
 * 优先分配在eden演示！
 *
 * VM参数: -verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
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
 * 程序说明:
 * 从GC日志可以看到，新生代eden区占用75%，from、to两个Survivor区和ParOldGen老年代都没有使用，
 * 验证了对象优先在Eden区分配的事实。
 * 按理说，eden区分配只是4M，应该占50%才对，事实分配后占用的比实际分配的要多，主要是因为Java对象
 * 并不是一个人在战斗，其它部分也占用了内存。
 */
public class AllocationTest01 {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation = new byte[4 * _1MB];
    }
}
