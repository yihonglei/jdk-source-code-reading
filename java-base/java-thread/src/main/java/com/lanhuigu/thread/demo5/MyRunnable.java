package com.lanhuigu.thread.demo5;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: MyRunnable
 * @Package: com.lanhuigu.thread.demo5
 * @date 2018/4/10 21:13
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        methodOne();
    }

    public void methodOne() {
        int localVariable1 = 45;

        MySharedObject localVariable2 = MySharedObject.sharedInstance;

        //... do more with local variables.
        methodTwo();
    }

    public void methodTwo() {
        Integer localVariable1 = new Integer(99);

        //... do more with local variable.
    }
}
