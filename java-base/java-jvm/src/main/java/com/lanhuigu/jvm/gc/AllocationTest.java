package com.lanhuigu.jvm.gc;

public class AllocationTest {
    private static final int _1MB = 1024 * 1024;
    /**
     * VM参数: -verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+UseSerialGC
     */
    public static void main(String[] args) {
        byte[] allocation1 = new byte[2 * _1MB];
        byte[] allocation2 = new byte[2 * _1MB];
    }
}
