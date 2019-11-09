package com.lanhuigu.thread.lock.reentrantlock.demo2;

/**
 * 关键字synchronized与wait()合notify()或notifyAll()结合可以实现等待/通知机制。
 * 而ReentrantLock和Condition配合也可以实现等待/通知机制。
 *
 * 使用notify()和notifyAll()无法选择性的通知线程。
 * 使用Condition的优点就是可以在Lock对象里面创建多个Condition(对象监视器)实例，
 * 线程对象可以注册在指定的Condition中，从而实现有选择性地进行线程通知，使线程调度更加的灵活。
 *
 * Condition类中常用方法:
 * await() 使线程等待相当于Object对象中的wait()方法
 * await(long time, TimeUnit unit)相当于Object对象中的wait(long timeout)方法
 * signal() 通知单个线程相当于Object对象中的notify()方法
 * signalAll() 通知所有线程相当于Object对象中的notifyAll()方法
 */
public class RunTest {
    public static void main(String[] args) {
        try {
            MyService service = new MyService();
            MyThread myThread = new MyThread(service);
            /**
             * 线程启动后执行run方法，调用MyService中的await()方法，
             * 使得线程处于等待状态
             */
            myThread.start();

            // 当前线程(main线程)休眠5秒后往下执行
            Thread.sleep(5000);

            /**
             * 调用signal方法，通知MyService中Condition(监视器)中注册的线程
             * 进行唤醒执行
             */
            service.signal();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
