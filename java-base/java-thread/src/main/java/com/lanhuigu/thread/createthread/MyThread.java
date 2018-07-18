package com.lanhuigu.thread.createthread;
/**
 * 通过继承Thread类，重写run方法，创建线程
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("通过继承Thread创建线程");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("多线程技术--代码运行结果与代码执行顺序或调用顺序无关");
    }
}
