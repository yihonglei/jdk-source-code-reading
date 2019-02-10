package com.lanhuigu.thread.threadstop;
/**
 * 暴力停止：
 * 调用stop方法，stop方法已经被废弃,同时使用stop方法强制停止线程，会导致某些收尾程序未完成，对象"解锁"，
 * 导致数据不同步，出现数据不一致问题。
 */
public class StopThread extends Thread{
    private int count = 1;
    @Override
    public void run() {
        try {
            while (true) {
                count++;
                System.out.println("count = " + count);
                Thread.sleep(2000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            StopThread stopThread = new StopThread();
            stopThread.start();

            Thread.sleep(8000);
            stopThread.stop();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
