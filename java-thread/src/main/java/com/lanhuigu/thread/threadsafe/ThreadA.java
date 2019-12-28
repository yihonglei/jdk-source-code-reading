package com.lanhuigu.thread.threadsafe;

/**
 * 定义线程A
 *
 * @author yihonglei
 *  2019/2/11 17:45
 */
public class ThreadA extends Thread {
    private HasSelfPrivateNum hasSelfPrivateNum;

    public ThreadA(HasSelfPrivateNum hasSelfPrivateNum) {
        super();
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        hasSelfPrivateNum.addUser("a");
    }
}
