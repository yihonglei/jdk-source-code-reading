package com.lanhuigu.java8.defaultmethod;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.defaultmethod
 * @date 2018/3/14 17:19
 */
public interface Sized {
    int size();
    default boolean isEmpty() {
        return size() == 0;
    }
}
