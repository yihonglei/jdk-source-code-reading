package com.jpeony.concurrent.locks.reentrantlock.demo3;

/**
 * 多等待/多通知测试
 */
public class RunTest {
    public static void main(String[] args) {
        try {
            MyService service = new MyService();
            ThreadA threadA = new ThreadA(service);
            threadA.setName("AAAAA");
            threadA.start();

            ThreadB threadB = new ThreadB(service);
            threadB.setName("BBBBB");
            threadB.start();

            // main线程休眠5秒，才执行后面的代码
            Thread.sleep(5000);
            /*
             * 线程休眠5秒后开始执行service.signalAll_A(),
             * 单纯就是唤醒ThreadA线程，不唤醒ThreadB线程，
             * 这么测试的目的，就是想验证Condition能否做到只唤醒部分线程
             */
            service.signalAll_A();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
