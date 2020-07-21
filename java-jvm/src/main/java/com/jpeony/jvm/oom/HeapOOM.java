package com.jpeony.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * OutOfMemoryError内存溢出演示！
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError (导出xx.hprof文件默认在当前工程所在目录)
 *
 * 可以通过增加-XX:HeapDumpPath=./来指定dump文件存储路径。
 * 描述: -XX:+HeapDumpOnOutOfMemoryError 生成hprof文件，该文件在项目目录下
 *
 * @author yihongeli
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
