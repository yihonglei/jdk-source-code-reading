package com.lanhuigu.thread.threadsafe;

/**
 * 方法内部的私有变量都是线程安全的。
 *
 * @author yihonglei
 * @date 2019/2/11 17:45
 */
public class HasSelfPrivateNum {
    int num = 0;
    public synchronized void addUser(String username) {
        try {

            if (username.equals("a")) {
                num = 500;
                System.out.println("a set over!");
                Thread.sleep(2000);
            } else {
                num = 1000;
                System.out.println("b set over!");
            }
            System.out.println("username = " + username + " & num = " + num);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
