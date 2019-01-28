package com.lanhuigu.thread.stopthread;

/**
 * 异常法：
 * 判断线程中断状态为true时，抛线程中断异常。
 */
public class ExceptionMethod extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.interrupted()) {// 判断线程是否中断
                    System.out.println("线程已经停止，退出代码执行");
                    throw new InterruptedException();
                }
                System.out.println("i = " + (i + 1));
            }

            System.out.println("跳出for循环，执行for循环后的代码");
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        try {
            ExceptionMethod exceptionMethod = new ExceptionMethod();
            exceptionMethod.start();

            Thread.sleep(1000);
            exceptionMethod.interrupt();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
