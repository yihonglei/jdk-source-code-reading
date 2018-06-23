package com.lanhuigu.java8.lambda;

/**
 * lambda线程调用简化
 */
public class LambdaThreadTest {
    public static void main(String[] args) {
        // 创建线程（原始方式）
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1-Demo01Test");
            }
        });
        // Java8 lambda方式
        Thread thread2 = new Thread(() -> System.out.println("Thread2-Demo01Test"));

        // 启动线程
        thread1.start();
        thread2.start();
    }
}
