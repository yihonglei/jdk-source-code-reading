package com.jpeony.concurrent.threadpool;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yihonglei
 */
public class RejectedExecutionHandlerTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executorA = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(100),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 0; i < 500; i++) {
            int s = i;
            executorA.execute(() -> {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("【" + LocalTime.now() + "】线程 " + Thread.currentThread() + "正在执行任务" + s);
            });
        }
    }
}
