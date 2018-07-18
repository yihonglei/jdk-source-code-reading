package com.lanhuigu.thread.stopthread;

/**
 * 异常法: 判断线程中断状态为true时，抛线程中断异常
 */
public class ExceptionMethod extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            if (this.interrupted()) {// 判断线程是否中断
                System.out.println("线程已经停止，退出代码执行");
                break;
            }
            System.out.println("i = " + (i+1));
        }
    }

    public static void main(String[] args) {
        try {
            ExceptionMethod exceptionMethod = new ExceptionMethod();
            exceptionMethod.start();

            Thread.sleep(3000);
            exceptionMethod.interrupt();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
