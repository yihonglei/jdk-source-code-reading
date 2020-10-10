package com.jpeony.concurrent.threadlocal;

/**
 * ThreadLocal类的get方法和null值
 *
 * @author yihonglei
 */
public class RunSimple {
    private static ThreadLocal THREAD_LOCAL = new ThreadLocal();

    public static void main(String[] args) {
        if (THREAD_LOCAL.get() == null) {
            System.out.println("未放入值");
            THREAD_LOCAL.set("放入值");
        }
        // 获取值
        System.out.println("print：" + THREAD_LOCAL.get());
    }
}
