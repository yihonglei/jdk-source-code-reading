package com.lanhuigu.java.compute;

/**
 * 移位
 *
 * @author yihonglei
 */
public class MoveTest {
    public static void main(String[] args) {
        int x, y;
        x = 5 >> 2;
        y = x >>> 2;
        System.out.println(y);
    }
}
