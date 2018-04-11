package com.lanhuigu.thread.demo1;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: MyThread
 * @Package: com.lanhuigu.thread
 * @date 2018/4/10 15:10
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread running");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
