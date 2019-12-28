package com.lanhuigu.jvm.gc;

/**
 * @author yihonglei
 *  2019/4/12 18:51
 */
public class Tmp {
    public static void main(String[] args) throws InterruptedException {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[5 * 1024 * 1024];
        allocation2 = new byte[800 * 1024];
        allocation3 = new byte[800 * 1024];

        Thread.sleep(30000000);
    }
}
