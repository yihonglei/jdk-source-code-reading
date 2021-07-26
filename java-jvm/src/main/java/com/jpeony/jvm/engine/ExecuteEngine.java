package com.jpeony.jvm.engine;

/**
 * 执行引擎分析
 *
 * @author yihonglei
 */
public class ExecuteEngine {
    /**
     * 一个方法对应一块栈帧内存区域，线程在启动执行时执行到某个方法就创建该方法对应的栈帧，
     * 该方法执行完成后自动释放该方法所占用的内存区域。
     */
    public int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;

        return c;
    }

    /**
     * main 入口
     */
    public static void main(String[] args) {
        ExecuteEngine test = new ExecuteEngine();
        test.compute();
        // compute() 执行完返回方法出口的位置，在 compute() 方法栈帧的方法出口信息中存储了返回地址。
        // System.out.println("test");
    }
}
