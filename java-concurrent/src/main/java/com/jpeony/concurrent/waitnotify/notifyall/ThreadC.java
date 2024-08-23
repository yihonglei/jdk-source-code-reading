package com.jpeony.concurrent.waitnotify.notifyall;

public class ThreadC extends Thread {
    private Object lock;

    public ThreadC(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        MyService service = new MyService();
        service.serviceMethod(lock);
    }
}
