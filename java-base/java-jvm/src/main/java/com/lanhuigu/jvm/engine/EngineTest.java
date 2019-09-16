package com.lanhuigu.jvm.engine;

/**
 * 执行引擎演示代码
 */
public class EngineTest {
    /**
     * public
     */
    public static int calc() {
        int a = 100;
        int b = 200;
        int c = 300;

        return (a + b) * c;
    }

    /**
     * main 入口
     */
    public static void main(String[] args) {
        System.out.println(calc());
    }
}
