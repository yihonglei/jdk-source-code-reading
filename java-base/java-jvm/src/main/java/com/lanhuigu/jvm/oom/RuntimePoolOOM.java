package com.lanhuigu.jvm.oom;

import java.util.LinkedList;

/**
 * VM Args:
 * jdk6以前：-XX:PermSize=10M -XX:MaxPermSize=10M
 * jdk7开始：-Xms10m -Xmx10m -XX:-UseGCOverheadLimit
 */
public class RuntimePoolOOM {
    public static void main(String[] args){
        // 使用list保持常量的引用，避免Full GC回收常量池
        LinkedList<String> list=new LinkedList<>();
        // 疯狂添加常量到list
        int i=1;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
