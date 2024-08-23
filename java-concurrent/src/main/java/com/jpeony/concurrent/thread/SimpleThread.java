package com.jpeony.concurrent.thread;

public class SimpleThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new SimpleRunner(), "SimpleRunner");
        t.start();
        Thread.sleep(10);
    }

    public static class SimpleRunner implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep(1);
                    System.out.println("simple running...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("simple finally end");
            }
        }
    }
}
