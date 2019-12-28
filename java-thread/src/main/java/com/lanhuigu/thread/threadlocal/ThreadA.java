package com.lanhuigu.thread.threadlocal;

/**
 * @author yihonglei
 */
public class ThreadA extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                DataTools.tl.set("A_Thread_" + System.currentTimeMillis());
                // 获取当前线程私有数据
                System.out.println("线程A获取的值:" + DataTools.tl.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
