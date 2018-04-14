package com.lanhuigu.thread.demo6;

/**
 * @author yihonglei
 * @ClassName: ThreadTest
 * @Package: com.lanhuigu.thread.demo6
 * @date 2018/4/14 13:38
 * @version 1.0.0
 */
public class ThreadTest {
    public static void main(String[] args) {
        try {
            ThreadA threadA = new ThreadA();
            threadA.start();

            Thread.sleep(3000);

            ThreadB threadB = new ThreadB();
            threadB.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
