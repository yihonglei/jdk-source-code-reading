package com.jpeony.thread.threadmethod;

/**
 * 获取线程id
 */
public class GetIdMethod extends Thread{
    @Override
    public void run() {
        System.out.println("线程ID=" + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        GetIdMethod getIdThread = new GetIdMethod();
        getIdThread.start();
    }
}
