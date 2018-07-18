package com.lanhuigu.thread.stopthread;

public class InterruptMethod extends Thread{
    @Override
    public void run() {
        // 循环50万次
        for (int i = 0; i < 500000; i++) {
            System.out.println("i = " + (i+1));
        }
    }

    public static void main(String[] args) {
        try {
            InterruptMethod thread = new InterruptMethod();
            thread.start();// 启动InterruptMethod线程
            Thread.sleep(2000);// main线程休眠2秒
            thread.interrupt();// 调用interrupt中断线程
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
