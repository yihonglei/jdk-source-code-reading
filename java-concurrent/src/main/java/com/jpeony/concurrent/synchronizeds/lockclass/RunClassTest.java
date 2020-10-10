package com.jpeony.concurrent.synchronizeds.lockclass;

/**
 * 类锁测试
 *
 * @author yihonglei
 */
public class RunClassTest {
    public static void main(String[] args) {
        Task mTask = new Task();
        ThreadC tc = new ThreadC(mTask);
        ThreadD td = new ThreadD(mTask);
        ThreadE te = new ThreadE(mTask);

        tc.setName("C");// 静态同步方法
        td.setName("D");// 静态同步方法
        te.setName("E");// 静态方法同步代码块

        tc.start();
        td.start();
        te.start();
    }
}