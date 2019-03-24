package com.lanhuigu.thread.volatiledemo;

/**
 * sign标识是否停止线程:
 * sign false表示不停止，如果为true 表示停止。
 *
 * @author yihonglei
 * @date 2019/2/12 12:37
 */
public class StopThread {
    private static boolean sign; // 非volatile变量
    //volatile private static boolean sign; // volatile变量

    public static void main(String[] args) throws InterruptedException {
        Thread readThread = new Thread(() -> {
            while (!sign) {
                // System.out.println("加上println方法");
            }
        });

        readThread.start(); // 启动线程
        Thread.sleep(1000); // 休眠一秒
        sign = true; // 期望过一秒后线程停止
    }
}
