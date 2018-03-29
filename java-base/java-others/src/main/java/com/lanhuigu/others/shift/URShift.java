package com.lanhuigu.others.shift;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: URShift
 * @Package: com.lanhuigu.others.shift
 * @date 2018/3/27 9:26
 */
public class URShift {
    public static void main(String[] args) {
        int i = -1;
        System.out.println(Integer.toBinaryString(i));
        i >>>= 10;
        System.out.println(Integer.toBinaryString(i));
    }
}
