package com.jpeony.concurrent.waitnotify.notifyall;

/**
 * wait(): 使线程等待，进入阻塞队列。
 * wait(long): 表示一个线程等待指定时间内是否有线程对锁进行唤醒，如果没有，将自动唤醒。
 * general(): 随机通知一个线程唤醒，如果通知线程少于等待线程时，将不能及时唤醒多个线程。
 * notifyAll(): 唤醒所有线程。
 *
 * @author yihonglei
 */
public class RunTest {
    public static void main(String[] args) {
        try {
            // 创建一个锁对象
            Object lock = new Object();

            ThreadA threadA = new ThreadA(lock);
            threadA.setName("A");
            threadA.start();

            ThreadB threadB = new ThreadB(lock);
            threadB.setName("B");
            threadB.start();

            ThreadC threadC = new ThreadC(lock);
            threadC.setName("C");
            threadC.start();

            // 休眠5秒后调用唤醒线程
            Thread.sleep(5000);

            NotifyThread notifyThread = new NotifyThread(lock);
            notifyThread.setName("NotifyThread");
            notifyThread.start();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
