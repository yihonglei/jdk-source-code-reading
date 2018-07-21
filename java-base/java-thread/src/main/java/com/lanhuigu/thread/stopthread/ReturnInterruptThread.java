package com.lanhuigu.thread.stopthread;

public class ReturnInterruptThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            if (this.interrupted()) {
                System.out.println("通过return，实现线程停止效果!");
                return;
            }
            System.out.println(" i = " + (i+1));
        }
    }

    public static void main(String[] args) {
        try {
            ReturnInterruptThread returnThread = new ReturnInterruptThread();
            returnThread.start();

            Thread.sleep(2000);
            returnThread.interrupt();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
