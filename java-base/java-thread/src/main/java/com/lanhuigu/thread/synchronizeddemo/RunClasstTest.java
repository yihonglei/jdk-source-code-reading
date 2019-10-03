package com.lanhuigu.thread.synchronizeddemo;

/**
 * 类锁测试
 */
public class RunClasstTest {
    public static void main(String[] args) {
        Task mTask = new Task();
        ThreadC tc = new ThreadC(mTask);
        ThreadD td = new ThreadD(mTask);
        ThreadE te = new ThreadE(mTask);

        // 静态同步方法
        tc.setName("C");
        // 静态同步方法
        td.setName("D");
        // 静态方法同步代码块
        te.setName("E");

        tc.start();
        td.start();
        te.start();
    }
}
