package com.lanhuigu.thread.threadpool.newSingleThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Execotors01
 * @Package: com.lanhuigu.thread.threadpool.newSingleThreadExecutor
 * @date 2018/8/5 14:00
 */
public class Execotors01 {
    // 线程启动
    public static void main(String[] args) {
        // 分析源码
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个线程");
            }
        });
    }
}
