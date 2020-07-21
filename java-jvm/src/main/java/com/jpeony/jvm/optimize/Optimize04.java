package com.jpeony.jvm.optimize;

/**
 * 【尽量采用懒加载的策略，即在需要的时候才创建】
 *
 * @author yihongeli
 */
public class Optimize04 {

    /**
     * 饿汉模式
     */
//    private final static Optimize04 INSTANCE = new Optimize04();

//    private Optimize04() {
//
//    }
//
//    public static Optimize04 getInstance() {
//        return INSTANCE;
//    }

    /**
     * 懒汉模式
     */
    private static Optimize04 instance;

    private Optimize04() {

    }

    public static Optimize04 getInstance() {
        if (instance == null) {
            synchronized (Optimize04.class) {
                if (instance == null) {
                    instance = new Optimize04();
                }
            }
        }
        return instance;
    }
}
