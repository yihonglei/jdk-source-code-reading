package com.lanhuigu.jvm.table;

/**
 * @author yihonglei
 * @ClassName: PlaceHolderTest
 * @Package: com.lanhuigu.jvm.table
 * @date 2018/5/1 14:54
 * @version 1.0.0
 */
public class PlaceHolderTest {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }
}
