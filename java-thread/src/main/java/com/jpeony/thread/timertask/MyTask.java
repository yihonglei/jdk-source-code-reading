package com.jpeony.thread.timertask;

import java.util.TimerTask;
/**
 * 新建一个任务继承于TimerTask
 */
public class MyTask extends TimerTask{

    @Override
    public void run() {
        System.out.println("The task begin startTime:" + System.currentTimeMillis());
    }

}
