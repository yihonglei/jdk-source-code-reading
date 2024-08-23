package com.jpeony.concurrent.thread;

/**
 * 守护线程启动前设置，同时 finally 语句块不一定会执行。
 */
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new DaemonRunner(), "DaemonRunner");
        // 启动前设置
        t.setDaemon(true);
        t.start();

        Thread.sleep(10);
    }

    public static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1);
                    System.out.println("daemon running...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("daemon finally end");
            }
        }
    }
}
