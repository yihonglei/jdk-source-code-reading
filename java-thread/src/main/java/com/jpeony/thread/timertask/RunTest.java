package com.jpeony.thread.timertask;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * Timer类负责计划任务的功能，也即指定的时间开始执行某个任务。
 * Timer类的作用只是用于设置计划任务，对任务做排期，而任务的封装类则通过TimerTask完成。
 * 执行计划任务的代码要放入TimerTask的子类中，因为TimerTask为抽象类，具体功能均由子类处理。
 */
public class RunTest {
    public static void main(String[] args) {
        // 日历
        System.out.println("curSystemTime:" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        Date runStartDate = calendar.getTime();

		// 新建一个任务
        MyTask task = new MyTask();

        // 定义一个任务调度器
        Timer timer = new Timer();

		// 将task任务交给timer去安排执行，什么时候执行由timer决定，执行什么内容由task决定。
        timer.schedule(task, runStartDate);
    }
}
