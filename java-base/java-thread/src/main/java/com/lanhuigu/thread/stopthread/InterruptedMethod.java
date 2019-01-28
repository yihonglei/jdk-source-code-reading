package com.lanhuigu.thread.stopthread;

/**
 * 判断当前线程是否已经中断，同时执行结束时清除线程状态并将线程状态标识为默认状态false。
 */
public class InterruptedMethod extends Thread {
    @Override
    public void run() {
        // 循环50万次
        for (int i = 0; i < 500000; i++) {
            System.out.println("i = " + (i + 1));
        }
    }

    public static void main(String[] args) {
        try {
            InterruptedMethod thread = new InterruptedMethod();
            thread.start();// 启动InterruptMethod线程
            Thread.sleep(2000);// main线程休眠2秒
            thread.interrupt();// 调用interrupt中断线程
            System.out.println("是否停止1:" + thread.interrupted());// 判断是否已经中断
            System.out.println("是否停止2:" + thread.interrupted());// 判断是否已经中断
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
