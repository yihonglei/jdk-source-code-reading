package com.lanhuigu.thread.cyclicbarrier;

import java.util.concurrent.*;

/**
 * 运动员跑步全部就绪-->鸣枪-->开跑！
 *
 * @author yihonglei
 */
public class AthleteThread extends Thread {
    /**
     * 操场上有5条跑道，当运动员全部就绪-->鸣枪-->开跑！
     * 这里new Runnable作为barrierAction，也就是屏障打破后触发的动作，比如运行员就绪后，鸣枪！
     */
    private static final CyclicBarrier playGround = new CyclicBarrier(5, new Runnable() {
        @Override
        public void run() {
            System.out.println("鸣枪!!!!!!!!!!!!!!!!");
        }
    });

    /**
     * 运动员编号
     */
    private Integer num;

    /**
     * 构造器
     *
     * @param num 运动员编号
     */
    private AthleteThread(Integer num) {
        this.num = num;
    }

    @Override
    public void run() {
        try {
            System.out.println("运动员编号：" + num + "就绪...................");
            /*
             * playGround 每次调用await时，count减1，直到count为0时，打破屏障，所有调用await的线程同时开始执行。
             */
            playGround.await();
            System.out.println("运动员编号：" + num + "开跑>>>>>>>>>>>>>>>>>>>");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 5个运动员参加运动会
        for (int i = 1; i <= 5; i++) {
            executorService.execute(new AthleteThread(i));
        }

        executorService.shutdown();
    }
}
