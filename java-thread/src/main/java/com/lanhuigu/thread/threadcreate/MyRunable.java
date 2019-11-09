package com.lanhuigu.thread.threadcreate;

/**
 * 通过实现Runnable接口，实现run方法，创建线程
 */
public class MyRunable implements Runnable{
    @Override
    public void run() {
        System.out.println("通过实现Runnable接口创建线程");
    }

    public static void main(String[] args) {
        MyRunable runable = new MyRunable();
        Thread thread = new Thread(runable);
        thread.start();
        System.out.println("多线程技术--代码运行结果与代码执行顺序或调用顺序无关");
    }
}
