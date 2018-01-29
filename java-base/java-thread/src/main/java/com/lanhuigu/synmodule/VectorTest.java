package com.lanhuigu.synmodule;

import java.util.Vector;

/**
 * Vector为早期的同步容器类:
 * 将状态封装起来，并对每个公有方法都进行同步，使得每次只有一个线程能访问容器的状态。
 */
public class VectorTest {
    /**
     * 获取Vector中的最后一个元素
     * @param list
     * @return
     */
    public static Object getLast(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            return list.get(lastIndex);
        }
    }

    /**
     * 删除Vector中的最后一个元素
     * @param list
     */
    public static void deleteLast(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            list.remove(lastIndex);
        }
    }
}
