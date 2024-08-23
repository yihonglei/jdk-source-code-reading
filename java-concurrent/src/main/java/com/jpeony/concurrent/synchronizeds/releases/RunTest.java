package com.jpeony.concurrent.synchronizeds.releases;

public class RunTest {
    public static void main(String[] args) {
        MyService myService = new MyService();

        ThreadA threadA = new ThreadA(myService);
        threadA.setName("A");
        threadA.start();

        ThreadB threadB = new ThreadB(myService);
        threadB.start();
        threadB.setName("B");
    }
}
