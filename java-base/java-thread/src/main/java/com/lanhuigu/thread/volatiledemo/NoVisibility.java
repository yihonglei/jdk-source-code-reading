package com.lanhuigu.thread.volatiledemo;

/**
 * 线程可见性测试，这是一段结果不可控的代码
 * @author yihonglei
 * @date 2018/9/16 22:04
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        /**
         * 主线程修写值，其子线程可能读到不同的情况，因为线程的执行顺序是由CPU控制执行的；
         *
         * 注意：
         * number = 42;
         * ready = true;
         * 这两行代码可能出现重排序；
         */
        number = 42;
        ready = true;
    }
}
