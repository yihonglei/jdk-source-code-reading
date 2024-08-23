package com.jpeony.concurrent.threadlocal;

/**
 * ThreadLocal类的get方法和null值
 */
public class RunSimple {
    private static ThreadLocal THREAD_LOCAL = new ThreadLocal();
    private static ThreadLocal THREAD_LOCAL2 = new ThreadLocal();

    public static void main(String[] args) {
        // 放入值
        THREAD_LOCAL.set("放入值");
        THREAD_LOCAL2.set("放入值2");
        // 获取值
        System.out.println("print-thread-local-1：" + THREAD_LOCAL.get());
        System.out.println("print-thread-local-2：" + THREAD_LOCAL2.get());
    }
}
