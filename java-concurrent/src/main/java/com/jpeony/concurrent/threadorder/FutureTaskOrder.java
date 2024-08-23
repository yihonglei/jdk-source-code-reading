package com.jpeony.concurrent.threadorder;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * FutureTask控制线程顺序，通过get方法阻塞获取上一个线程结果，只有当上一个线程执行完成并返回结果时，才继续执行下一个线程。
 */
public class FutureTaskOrder {
    public static void main(String[] args) {
        // 创建FutureTask
        FutureTask<String> task1 = new FutureTask<>(new Work(null));
        FutureTask<String> task2 = new FutureTask<>(new Work(task1));
        FutureTask<String> task3 = new FutureTask<>(new Work(task2));

        // 创建线程
        Thread t1 = new Thread(task1, "Thread-1");
        Thread t2 = new Thread(task2, "Thread-2");
        Thread t3 = new Thread(task3, "Thread-3");

        // 启动线程
        t1.start();
        t2.start();
        t3.start();
    }

    static class Work implements Callable<String> {
        private FutureTask<String> beforeTask;

        Work(FutureTask<String> beforeTask) {
            this.beforeTask = beforeTask;
        }

        @Override
        public String call() throws Exception {
            if (beforeTask != null) {
                // 阻塞等待，上一个线程执行完，才能继续执行
                beforeTask.get();
                System.out.println("thread start：" + Thread.currentThread().getName());
            } else {
                System.out.println("thread start：" + Thread.currentThread().getName());
            }
            return "Result " + Thread.currentThread().getName();
        }
    }
}
