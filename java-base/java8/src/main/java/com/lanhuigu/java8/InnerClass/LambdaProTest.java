package com.lanhuigu.java8.InnerClass;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.InnerClass
 * @date 2018/3/11 22:01
 */
public class LambdaProTest {
    public static void main(String[] args) {
        int a = 10;
        Runnable r1 = () -> {
            int b = 2;
            System.out.println(a);
        };
    }
}
