package com.lanhuigu.jvm.gc;

/**
 * @author yihonglei
 * @ClassName: Allocation
 * @Package: com.lanhuigu.jvm.gc
 * @date 2018/4/26 11:39
 * @version 1.0.0
 */
public class Allocation {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails (-XX;SubvivorRatio=8)
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; // 出现一次Minor GC
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
