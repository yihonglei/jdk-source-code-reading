package com.jpeony.base.finals;

/**
 * final内存模型
 */
public class FinalExample {
    /**
     * 普通变量
     */
    int i;
    /**
     * final变量
     */
    final int j;
    static FinalExample obj;

    public FinalExample() {
        i = 1;
        j = 2;
    }

    /**
     * 写线程A执行
     */
    public static void writer() {
        obj = new FinalExample();
    }

    /**
     * 读线程B执行
     */
    public static void reader() {
        /** 读对象引用 */
        FinalExample object = obj;
        /** 读普通域 */
        int a = object.i;
        /** 读final域 */
        int b = object.j;
    }

    public static void main(String[] args) {
        /* 线程A（这里用java8 lambda写法创建线程）*/
        Thread threadA = new Thread(FinalExample::writer);
        threadA.start();

        /* 线程B（这里用java8 lambda写法创建线程）*/
        Thread threadB = new Thread(FinalExample::reader);
        threadB.start();
    }

}
