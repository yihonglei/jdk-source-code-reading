package com.lanhuigu.jvm.gc;

/**
 * VM参数: -verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
 * -XX:PretenureSizeThreshold=3145728 -XX:+UseSerialGC
 */
public class PretenureSizeThresholdTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation = new byte[4 * _1MB];
    }
}
