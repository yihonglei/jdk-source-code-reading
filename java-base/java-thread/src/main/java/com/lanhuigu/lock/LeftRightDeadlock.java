package com.lanhuigu.lock;

/**
 * 锁顺序死锁（交错执行）
 */
public class LeftRightDeadlock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                /** 执行方法 */
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                /** 执行方法 */
            }
        }
    }
}
