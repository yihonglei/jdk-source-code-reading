package com.lanhuigu.thread.join;

/**
 * Join线程等待排队执行测试
 *
 * @author yihonglei
 */
public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1");
            }
        });


        // 等线程1执行完之后再执行线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2");
            }
        });

        t2.start();
        t1.start();

        // 线程1和线程2执行完后再执行main线程
        t1.join();
        t2.join();
        System.out.println("线程main");
    }

}
