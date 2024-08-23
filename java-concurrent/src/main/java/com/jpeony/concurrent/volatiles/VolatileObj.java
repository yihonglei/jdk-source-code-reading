package com.jpeony.concurrent.volatiles;

public class VolatileObj {
    /**
     * 普通变量，线程私有，多线程之间数据不共享
     */
    private int normal_i = 0;
    /**
     * 所有实例共享一个静态变量，保证唯一性，不保证多个线程之间数据的一致性，不一定能取到主存中最新的数据，例如 A 线程 new 的对象修改值对 B 线程可见，但是 B 线程不一定能马上看到 A 线程修改的最新值
     */
    public static int static_i = 0;
    /**
     * 所有线程操作同一个实例对象的，保证多个线程之间数据的一致性，一定能取到主存中最新的数据，但是多个实例有多个 volatile 变量，互不相关，不保证唯一性
     */
    private volatile int volatile_i = 0;
    /**
     * 所有实例数据共享一个静态变量，并且保证多线程之间数据的一致性，一定能取到主存中最新的数据，结合了 static 和 volatile 的特性
     */
    private static volatile int static_volatile_i = 0;

    public int getNormal_i() {
        return normal_i;
    }

    public void setNormal_i(int normal_i) {
        this.normal_i = normal_i;
    }

    public static int getStatic_i() {
        return static_i;
    }

    public static void setStatic_i(int static_i) {
        VolatileObj.static_i = static_i;
    }

    public int getVolatile_i() {
        return volatile_i;
    }

    public void setVolatile_i(int volatile_i) {
        this.volatile_i = volatile_i;
    }

    public static int getStatic_volatile_i() {
        return static_volatile_i;
    }

    public static void setStatic_volatile_i(int static_volatile_i) {
        VolatileObj.static_volatile_i = static_volatile_i;
    }
}
