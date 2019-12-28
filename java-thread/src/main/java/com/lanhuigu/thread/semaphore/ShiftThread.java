package com.lanhuigu.thread.semaphore;

/**
 * 大便！！！（画面感很强！）
 *
 * @author yihonglei
 */
public class ShiftThread extends Thread {
    private Toilet toilet;
    private Integer num;

    public ShiftThread(Toilet toilet, Integer num) {
        this.toilet = toilet;
        this.num = num;
    }

    @Override
    public void run() {
        try {
            // 获得坑
            Toilet.Pit pitAcquire = toilet.getPit();
            System.out.println("序号：" + num + "， " + pitAcquire.getDesc());
            // 解决大号
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放坑
            Toilet.Pit pitRelealse = toilet.releasePit();
            System.out.println("序号：" + num + "， " + pitRelealse.getDesc());
        }
    }
}
