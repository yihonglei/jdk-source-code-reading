package com.lanhuigu.jvm.optimize;

/**
 * 【慎用异常】
 * 不要在循环中使用try…catch…，应该把其放在最外层；
 * 异常对性能不利。抛出异常首先要创建一个新的对象，Throwable接口的构造函数调用名为fillInStackTrace()的本地同步方法，
 * fillInStackTrace()方法检查堆栈，收集调用跟踪信息。
 * 只要有异常被抛出，Java虚拟机就必须调整调用堆栈，因为在处理过程中创建 了一个新的对象。
 * 异常只能用于错误处理，不应该用来控制程序流程。
 */
public class Optimize05 {
    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            try {
                int j = 1 / 0;
            } catch (Exception e) {
                e.printStackTrace();
                // new RuntimeException("这是个异常");
            }
        }
    }
}
