package com.lanhuigu.thread.stopthread;

/**
 * 判断线程是否已经中断，不清除线程的中断状态标识状态。
 */
public class IsInterruptMethod extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("i = " + (i + 1));
        }
    }

    public static void main(String[] args) {
        try {
            IsInterruptMethod thread = new IsInterruptMethod();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            System.out.println("是否停止1:" + thread.isInterrupted());
            System.out.println("是否停止2:" + thread.isInterrupted());
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
