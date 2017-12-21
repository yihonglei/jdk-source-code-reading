package com.lanhuigu.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 含义:
 * -Xms20m 限制java初始堆大小为20M;
 * -Xmx20m 设置java最大堆大小为20M;
 * -XX:+HeapDumpOnOutOfMemoryError 通过该参数可以让虚拟机在出现异常时Dump出当前的内存堆转存快照，方便分析;
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
