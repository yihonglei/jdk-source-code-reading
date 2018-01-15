package com.lanhuigu.jvm;

import java.util.ArrayList;
import java.util.List;
/**
 * VM Args: -Xms100m -Xmx100m -XX:+UseSerialGC
 *
 * 用于测试JConsole监控工具
 */
public class OOMObjectTest {
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(1000);
            list.add(new OOMObject());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
