package com.jpeony.concurrent.waitnotify.notifyall;

public class ThreadB extends Thread {
    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        MyService service = new MyService();
        service.serviceMethod(lock);
    }
}
