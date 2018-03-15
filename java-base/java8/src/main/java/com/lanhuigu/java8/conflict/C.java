package com.lanhuigu.java8.conflict;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.conflict
 * @date 2018/3/15 10:26
 */
public class C implements B, A {
    public static void main(String[] args) {
        new C().hello();
    }
}
