package com.lanhuigu.thread.demo1;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: MyRunnable
 * @Package: com.lanhuigu.thread.demo1
 * @date 2018/4/10 15:13
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable running");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());

        thread.start();
    }
}
