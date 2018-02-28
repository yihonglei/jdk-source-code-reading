package com.lanhuigu.jvm;

/**
 * [0,8)的和
 */
public class TestSum {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            sum += i;
        }

        System.out.println("[0,8)的和:" + sum);
    }
}
