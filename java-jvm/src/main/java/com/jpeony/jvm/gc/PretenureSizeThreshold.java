package com.jpeony.jvm.gc;

/**
 * VM参数:
 * -verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+UseSerialGC
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
 * -XX:PretenureSizeThreshold=3145728 （3M）设置大对象的阀值，大于该值，直接进入老年代；【lll】
 *
 * -XX:+UseSerialGC 指定收集器为Serial
 *
 * 注意：PretenureSizeThreshold参数只对Serial和ParNew两款收集器有效，我这里用的是Jdk8，
 * 默认使用Parallel Scavenge，一般不需要设置，如果非得需要，可以考虑ParNew和CMS收集器组合。
 *
 * 程序说明:
 * 从结果可以看出eden区没怎么使用，from、to两个Survivor去未使用，老年代用了40%。
 * 因为分配对象为4M，大于设置的3M阀值，直接在老年代进行分配。
 */
public class PretenureSizeThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation = new byte[4 * _1MB];
    }
}
