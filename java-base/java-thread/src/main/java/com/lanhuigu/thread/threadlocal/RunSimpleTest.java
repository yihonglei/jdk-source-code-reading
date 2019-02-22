package com.lanhuigu.thread.threadlocal;
/**
 * ThreadLocal类的get方法和null值
 */
public class RunSimpleTest {
    public static ThreadLocal tl = new ThreadLocal();

    public static void main(String[] args) {
        if (tl.get() == null) {
            System.out.println("未放入值");
            tl.set("放入值");
        }
        // 获取值
        System.out.println(tl.get());
    }
}
