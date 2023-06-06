package com.jpeony.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 【堆内存 OutOfMemoryError 异常演示】
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 可以通过增加-XX:HeapDumpPath=./来指定dump文件存储路径。
 * 描述: -XX:+HeapDumpOnOutOfMemoryError 生成hprof文件，该文件在项目目录下，方便后续分析
 *
 * @author yihonglei
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
