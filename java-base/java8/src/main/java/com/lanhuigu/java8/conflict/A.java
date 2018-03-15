package com.lanhuigu.java8.conflict;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.conflict
 * @date 2018/3/15 10:24
 */
public interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}
