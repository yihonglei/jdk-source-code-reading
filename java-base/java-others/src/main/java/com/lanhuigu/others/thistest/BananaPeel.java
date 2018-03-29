package com.lanhuigu.others.thistest;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: BananaPeel
 * @Package: com.lanhuigu.others.thistest
 * @date 2018/3/29 9:22
 */
public class BananaPeel {
    public static void main(String[] args) {
        Banana a = new Banana();
        Banana b = new Banana();

        a.peel(1);
        b.peel(2);
    }
}

class Banana {
    void peel(int i) {
        System.out.println("i:" + i);
    }
}