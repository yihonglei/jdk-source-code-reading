package com.lanhuigu.thread.reentrantlock.demo1;

public class RunTest {
    public static void main(String[] args) {
        MyService service = new MyService();
        MyThread t1 = new MyThread(service);
        MyThread t2 = new MyThread(service);
        MyThread t3 = new MyThread(service);
        MyThread t4 = new MyThread(service);
        MyThread t5 = new MyThread(service);

        t1.setName("Thread-A");
        t2.setName("Thread-B");
        t3.setName("Thread-C");
        t4.setName("Thread-D");
        t5.setName("Thread-E");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
