package com.jpeony.thread.waitnotify.general;

/**
 * @author yihonglei
 *  2019/2/15 11:18
 */
public class ThreadA extends Thread {
    private MyList myList;

    public ThreadA(MyList myList) {
        super();
        this.myList = myList;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                // 往集合添加元素
                myList.addUserName("element" + (i + 1));
                System.out.println(Thread.currentThread().getName() + "添加了" + myList.size() + "个元素!");
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
