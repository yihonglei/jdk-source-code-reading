package com.lanhuigu.jvm.gc;

/**
 * VM参数: -verbose:gc -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+UseSerialGC
 */
public class Allocation {
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[5 * 1024 * 1024];
        allocation2 = new byte[800 * 1024];
        allocation3 = new byte[800 * 1024];
    }
}
