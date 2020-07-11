package com.jpeony.thread.locks.fair;

public class RunNotFair {
    public static void main(String[] args) {
        final Service service = new Service(false);

        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] =  new Thread(()->{
                System.out.println("*线程 " + Thread.currentThread().getName() + "运行了");
                service.serviceMethod();
            });
        }
        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
    }
}
