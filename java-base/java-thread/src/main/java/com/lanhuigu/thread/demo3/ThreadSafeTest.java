package com.lanhuigu.thread.demo3;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: ThreadSafeTest
 * @Package: com.lanhuigu.thread.demo3
 * @date 2018/4/10 20:22
 */
public class ThreadSafeTest {
    public void someMethod() {
        /** 局部变量是线程安全的 */
        long threadSafeInt = 0;
        threadSafeInt ++;
    }
}
