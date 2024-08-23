package com.jpeony.concurrent.synchronizeds.manyobject;

public class RunTest {
    public static void main(String[] args) {
        // 创建实例
        HasSelfPrivateNum hasSelfPrivateNumA = new HasSelfPrivateNum();
        HasSelfPrivateNum hasSelfPrivateNumB = new HasSelfPrivateNum();
        // 创建线程A
        ThreadA threadA = new ThreadA(hasSelfPrivateNumA);
        threadA.start();
        // 创建线程B
        ThreadB threadB = new ThreadB(hasSelfPrivateNumB);
        threadB.start();
    }
}
