package com.jpeony.concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Semaphore（信号量）测试
 *
 * @author yihonglei
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        try {
            Toilet toilet = new Toilet();
            ExecutorService executorService = Executors.newFixedThreadPool(10);
            for (int i = 1; i <= 30; i++) {
                executorService.execute(new ShiftThread(toilet, i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
