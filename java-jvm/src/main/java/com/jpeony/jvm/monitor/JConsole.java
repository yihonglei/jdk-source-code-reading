package com.jpeony.jvm.monitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 用JConsole进行性能监控
 * VM Args: -Xms100m -Xmx100m -XX:+UseSerialGC
 */
public class JConsole {
    /**
     * 内存占位符对象，一个OOMObject大约占64KB
     */
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            // 稍作延时，令监控曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }

        System.gc();
    }

    /**
     * 以64kb/50毫秒的速度往Java堆中填充数据，一共填充1000次
     */
    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }

}
