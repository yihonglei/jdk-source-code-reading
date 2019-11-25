package com.lanhuigu.thread.threadpool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 定时线程池:
 *
 * scheduleAtFixedRate ，是以上一个任务开始的时间计时，period时间过去后，检测上一个任务是否执行完毕，
 * 如果上一个任务执行完毕，则当前任务立即执行，如果上一个任务没有执行完毕，则需要等上一个任务执行完毕后立即执行。
 *
 * scheduleWithFixedDelay，是以上一个任务结束时开始计时，delay时间过去后，立即执行。
 *
 * @author yihonglei
 * @date 2019/2/25 14:29
 */
public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) {
        ScheduledExecutorService executorService =
                Executors.newScheduledThreadPool(10);

        // 程序启动5秒之后执行任务，只执行一次。
//        executorService.schedule(()->{
//            System.out.println("1");
//        }, 5, TimeUnit.SECONDS);

        // 【固定速率连续执行】程序启动3秒之后第一次执行任务，之后每隔3秒检查上一个任务是否执行完成，如果执行完成，则执行任务。
        executorService.scheduleAtFixedRate(()->{
            System.out.println("2，" + new Date());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 3, 3, TimeUnit.SECONDS);

        // 【非固定速率连续执行】程序启动3秒之后第一次执行任务，下一次任务执行时间为上一次任务执行结束延迟3秒后立即执行。
//        executorService.scheduleWithFixedDelay(()->{
//            System.out.println("3，" + new Date());
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, 3, 3, TimeUnit.SECONDS);
    }

}
