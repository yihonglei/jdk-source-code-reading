package com.lanhuigu.others.stat;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: ArraysOfPrimitives
 * @Package: com.lanhuigu.others.stat
 * @date 2018/4/9 10:55
 */
public class ArraysOfPrimitives {
    public static void main(String[] args) {
        int[] a1 = new int[10];
        a1[0] = 1;
        a1[1] = 2;
        a1[2] = 3;
        a1[3] = 4;

        int[] a2 = new int[]{1, 2, 3, 4, 5};

        int[] a3 = {1, 2, 3, 4, 5};

        for (int i = 0; i < a1.length; i ++) {
            System.out.println("a1["+ i+"]:" + a1[i]);
        }

        for (int i = 0; i < a2.length; i ++) {
            System.out.println("a2["+ i+"]:" + a2[i]);
        }

        for (int i = 0; i < a3.length; i ++) {
            System.out.println("a3["+ i+"]:" + a3[i]);
        }
    }
}
