package com.jpeony.jvm.oom;

import java.util.LinkedList;

/**
 * 【运行时常量池 OutOfMemoryError 异常演示演示】
 * VM Args:
 * jdk6以前：-XX:PermSize=10M -XX:MaxPermSize=10M
 * jdk7开始：-Xms10m -Xmx10m -XX:-UseGCOverheadLimit
 * <p>
 * 参数说明：
 * XX:+UseGCOverheadLimit：限制GC的运行时间。如果GC耗时过长，就抛OOM。
 */
public class RuntimePoolOOM {
    public static void main(String[] args) {
        // 使用list保持常量的引用，避免Full GC回收常量池
        LinkedList<String> list = new LinkedList<>();
        // 疯狂添加常量到list
        int i = 1;
        while (true) {
            /**
             * String.intern()方法是一个Native方法，它的作用是：
             * 如果字符串常量池中已经包含一个等于此String对象的字符串，则返回代表池中这个字符串的String对象；
             * 否则将此String对象包含的字符串添加到常量池中，并返回此String对象的引用。
             */
            list.add(String.valueOf(i++).intern());
        }
    }
}
