package com.jpeony.thread.threadmethod;

/**
 * Thread类中的currentThread()方法，返回当前的线程对象
 */
public class CurrentThreadMethod extends Thread{
    @Override
    public void run() {
        System.out.println("ThreadName = " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        CurrentThreadMethod currentThreadMethod = new CurrentThreadMethod();
        currentThreadMethod.start();
    }
}
