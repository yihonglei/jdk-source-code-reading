package com.jpeony.concurrent.threadlocal;

/**
 * 一个线程可以创建多个 ThreadLocal 对象
 */
public class MultiThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal threadLocal1 = new ThreadLocal();
        ThreadLocal threadLocal2 = new ThreadLocal();

        threadLocal1.set("one");
        threadLocal2.set("two");

        System.out.println(threadLocal1.get()); // one
        System.out.println(threadLocal2.get()); // two
    }
}
