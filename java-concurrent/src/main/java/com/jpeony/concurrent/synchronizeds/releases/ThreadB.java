package com.jpeony.concurrent.synchronizeds.releases;

/**
 * @author yihonglei
 */
public class ThreadB extends Thread {
    private MyService myService;

    public ThreadB(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.serviceMethod();
    }
}