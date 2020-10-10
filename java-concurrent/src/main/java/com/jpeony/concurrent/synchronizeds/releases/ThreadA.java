package com.jpeony.concurrent.synchronizeds.releases;

/**
 * @author yihonglei
 */
public class ThreadA extends Thread {
    private MyService myService;

    public ThreadA(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.serviceMethod();
    }
}
