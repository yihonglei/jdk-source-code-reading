package com.lanhuigu.thread.safethread;

/**
 * 方法内部的私有变量都是线程安全的
 */
public class HasSelfPrivateNum {
    public void addUser(String username) {
        try {
            int num = 0;
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
