package com.jpeony.base.compute;

/**
 * 移位
 */
public class MoveTest {
    public static void main(String[] args) {
        int x, y;
        x = 5 >> 2;
        y = x >>> 2;
        System.out.println(y);
    }
}
