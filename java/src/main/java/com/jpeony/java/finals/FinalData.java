package com.jpeony.java.finals;

import java.util.Random;

/**
 * final 修饰变量实例:
 * 对于一个final变量，如果是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；
 * 如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象。
 *
 * @author yihongeli
 */
public class FinalData {
    private static Random rand = new Random(47);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    /**
     * 编译为常量
     */
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;

    /**
     * 公开的常量类型
     */
    public static final int VALUE_THREE = 39;

    /**
     * 不能编译为常量
     */
    private final int i4 = rand.nextInt(20);
    static final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);

    /**
     * 修饰数组
     */
    private final int[] a = {1, 2, 3, 4, 5, 6};

    /**
     * 重写toString()方法
     */
    @Override
    public String toString() {
        return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
    }

    /**
     * 测试调用
     */
    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");

        fd1.v2.i++;
        fd1.v1 = new Value(9);
        for (int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++;
        }

        System.out.println(fd1);
        System.out.println("Creating new FinalData");
        FinalData fd2 = new FinalData("fd2");
        System.out.println(fd1);
        System.out.println(fd2);
    }
}

class Value {
    int i;

    public Value(int i) {
        this.i = i;
    }
}
