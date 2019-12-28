package com.lanhuigu.thread.threadsafe;
/**
 * 定义线程B
 *
 * @author yihonglei
 *  2019/2/11 17:45
 */
public class ThreadB extends Thread {
    private HasSelfPrivateNum hasSelfPrivateNum;

    public ThreadB(HasSelfPrivateNum hasSelfPrivateNum) {
        super();
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        hasSelfPrivateNum.addUser("b");
    }
}
