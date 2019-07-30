package com.lanhuigu.jvm.gc;

/**
 * VM参数: -verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
 * -XX:+UseSerialGC -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
 */
public class TenuringThresholdTest {
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
