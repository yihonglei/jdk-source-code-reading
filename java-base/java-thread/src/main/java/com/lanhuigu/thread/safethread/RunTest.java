package com.lanhuigu.thread.safethread;

public class RunTest {
    public static void main(String[] args) {
        // 创建实例
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        // 创建线程A
        ThreadA threadA = new ThreadA(hasSelfPrivateNum);
        threadA.start();
        // 创建线程B
        ThreadB threadB = new ThreadB(hasSelfPrivateNum);
        threadB.start();
    }
}
