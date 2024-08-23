package com.jpeony.concurrent.waitnotify.notifyall;

public class ThreadA extends Thread {
    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        MyService service = new MyService();
        service.serviceMethod(lock);
    }
}
