package com.lanhuigu.thread.locks.reentrantlock.demo4;

/**
 * Condition实现生产/消费模式测试
 *
 * @author yihonglei
 */
public class RunTest {

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        // 创建线程，线程启动执行run方法里面调用await进行等待，等待线程注册到condition中
        MyThread t1 = new MyThread(task);
        t1.start();

        // main线程休眠5秒
        Thread.sleep(5000);

        // 通知注册到condition中的线程进行唤醒执行
        task.signal();
    }
}
