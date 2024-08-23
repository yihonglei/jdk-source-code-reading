package com.jpeony.concurrent.util;

import java.util.concurrent.TimeUnit;

/**
 * 休眠工具
 */
public class SleepUtils {
    public static void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
