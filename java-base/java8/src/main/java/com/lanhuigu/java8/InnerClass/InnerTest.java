package com.lanhuigu.java8.InnerClass;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.InnerClass
 * @date 2018/3/11 21:51
 */
public class InnerTest {
    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("Hello Lambda!");
        Thread t1 = new Thread(r1);
        t1.start();
    }
}
