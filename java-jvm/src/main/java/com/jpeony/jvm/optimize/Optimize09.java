package com.jpeony.jvm.optimize;

/**
 * 乘法/除法等采用移位操作
 *
 * @author yihonglei
 */
public class Optimize09 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i += 5) {
            int a = i * 8;
            int b = i / 2;
        }
        System.out.println("first耗时:" + (System.currentTimeMillis() - start));

        long startS = System.currentTimeMillis();
        for (int i = 0; i < 100000; i += 5) {
            int c = i << 3;
            int d = i >> 1;
        }
        System.out.println("second耗时:" + (System.currentTimeMillis() - startS));
    }
}
