package com.lanhuigu.thread.lock.synchronizeddemo;

/**
 * 对象锁测试
 */
public class RunObjectTest {
    public static void main(String[] args) {
        Task mTaskA = new Task();
        Task mTaskB = new Task();

        ThreadA ta1 = new ThreadA(mTaskA);
        ThreadA ta2 = new ThreadA(mTaskB);

        ThreadB tb1 = new ThreadB(mTaskA);
        ThreadB tb2 = new ThreadB(mTaskB);

        ta1.setName("A1");
        ta2.setName("A2");

        tb1.setName("B1");
        tb2.setName("B2");

        ta1.start();
        ta2.start();
        tb1.start();
        tb2.start();
    }
}
