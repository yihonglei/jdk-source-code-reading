package com.jpeony.concurrent.waitnotify.no;

public class ThreadB extends Thread {
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
                    // 异常法退出线程
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
