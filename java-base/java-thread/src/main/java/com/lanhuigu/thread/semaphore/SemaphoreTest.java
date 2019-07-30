package com.lanhuigu.thread.semaphore;

import java.util.concurrent.*;

/**
 * Semaphore（信号量）测试
 *
 * @author yihonglei
 * @date 2018/8/5 11:35
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        try {
            Toilet toilet = new Toilet();
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            for (int i = 1; i <= 30; i ++) {
                executorService.execute(new ShiftThread(toilet, i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
