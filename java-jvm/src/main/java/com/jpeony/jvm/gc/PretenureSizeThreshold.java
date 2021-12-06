package com.jpeony.jvm.gc;

/**
 * JVM 参数配置：
 * -verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+UseSerialGC
 * JVM 参数说明：
 * -verbose:gc 输出显示虚拟机运行信息；
 * -XX:+PrintGCDetails 打印内存回收日志；
 * -Xms20M -Xmx20M -Xmn10M 限制堆大小为 20M，不可以扩展，10M 分配给新生代，剩下 10M 分配给老年代；
 * -XX:SurvivorRatio=8 配置 Eden 区与一个 Survivor 区的比例，这里是默认的 8:1，不用显示配置也可以；
 * -XX:PretenureSizeThreshold=3145728 （3M）设置大对象的阀值，大于该值，直接进入老年代；
 * -XX:+UseSerialGC 指定收集器为 Serial
 * 注意：PretenureSizeThreshold 参数只对 Serial 和 ParNew 两款收集器有效，我这里用的是 Jdk8，
 * 默认使用 Parallel Scavenge，一般不需要设置，如果非得需要，可以考虑 ParNew 和 CMS 收集器组合。
 * 程序说明：
 * 从结果可以看出 eden 区没怎么使用，from、to 两个 Survivor 去未使用，老年代用了40%。
 * 因为分配对象为 4M，大于设置的 3M 阀值，直接在老年代进行分配。
 *
 * @author yihonglei
 */
public class PretenureSizeThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation = new byte[4 * _1MB];
    }
}
