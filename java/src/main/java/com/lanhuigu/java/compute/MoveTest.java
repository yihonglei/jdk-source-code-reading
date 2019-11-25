package com.lanhuigu.java.compute;

/**
 * 移位
 *
 * @author yihonglei
 * @date 2019/11/22 10:53 AM
 */
public class MoveTest {
    public static void main(String[] args) {
        int x, y;
        x = 5 >> 2;
        y = x >>> 2;
        System.out.println(y);
    }
}
