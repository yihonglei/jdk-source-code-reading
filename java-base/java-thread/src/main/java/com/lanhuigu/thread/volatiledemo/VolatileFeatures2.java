package com.lanhuigu.thread.volatiledemo;

/**
 * 单线程演示volatile变量特性
 */
public class VolatileFeatures2 {
    /** 64为的普通long型变量 */
    long v1 = 0L;

    /** 对单个变量的写用同一个锁同步 */
    public synchronized void set(long l) {
        v1 = l;
    }

    /** 普通方法调用 */
    public void getAndIncrement() {
        long temp = get();
        //
        temp += 1L;
        set(temp);
    }

    /** 单个volatile变量的读 */
    public long get() {
        return v1;
    }
}
