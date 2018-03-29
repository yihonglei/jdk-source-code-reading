package com.lanhuigu.others.thistest;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Leaf
 * @Package: com.lanhuigu.others.thistest
 * @date 2018/3/29 9:33
 */
public class Leaf {
    int i = 0;
    Leaf increment() {
        i ++;
        // this表示当前对象
        return this;
    }

    void print() {
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        Leaf x = new Leaf();
        x.increment().increment().increment().print();
    }
}
