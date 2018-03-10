package com.lanhuigu.java8.inter;

/**
 *
 * @ClassName: Test
 * @Package: com.lanhuigu.java8.inter
 * @Author yihonglei
 * @date 2018/3/6 9:42
 * @version 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        process(()-> System.out.println("Hello World 1"));
    }

    public static void process(Runnable r) {
        r.run();
    }
}
