package com.lanhuigu.thread.waitnotify.notify;

/**
 * 测试代码
 *
 * @author yihonglei
 * @date 2019/2/15 16:43
 */
public class RunTest {
    public static void main(String[] args) {
        try {
            Object lock = new Object();
            ThreadA threadA = new ThreadA(lock);
            threadA.start();

            // 5秒后调用唤醒线程，调用notify方法，唤醒等待线程
            Thread.sleep(5000);

            ThreadB threadB = new ThreadB(lock);
            threadB.start();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
