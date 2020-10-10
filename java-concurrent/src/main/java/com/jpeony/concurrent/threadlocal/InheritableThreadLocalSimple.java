package com.jpeony.concurrent.threadlocal;

/**
 * InheritableThreadLocal获取父线程往ThreadLocal里面塞入的值。
 *
 * @author yihonglei
 */
public class InheritableThreadLocalSimple {
    public static ThreadLocal<String> THREAD_LOCAL = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        // 往main-thread塞入值
        THREAD_LOCAL.set("parentThread");
        // 启动新线程
        Thread thread = new MyThread();
        thread.start();
        System.out.println("main = " + THREAD_LOCAL.get());
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread = " + THREAD_LOCAL.get());
        }
    }
}
