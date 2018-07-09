package com.lanhuigu.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 描述: -XX:+HeapDumpOnOutOfMemoryError 生成hprof文件，该文件在项目目录下
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            // 疯狂创建对象
            list.add(new OOMObject());
        }
    }

}
