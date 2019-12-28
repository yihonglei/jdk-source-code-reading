package com.lanhuigu.thread.waitnotify.general;

/**
 * @author yihonglei
 *  2019/2/15 11:19
 */
public class ThreadB extends Thread{
    private MyList myList;

    public ThreadB(MyList myList) {
        super();
        this.myList = myList;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "还活着");
                if (myList.size() >= 5) {
                    System.out.println("A线程已经将list添加了5个元素，B线程要退出了");
                    throw new InterruptedException();// 异常法退出线程
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
