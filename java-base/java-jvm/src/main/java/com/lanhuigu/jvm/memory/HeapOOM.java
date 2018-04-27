package com.lanhuigu.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 描述: -XX:+HeapDumpOnOutOfMemoryError 生成hprof文件，该文件在项目目录下
 * @author yihonglei
 * @ClassName: HeapOOM
 * @Package: com.lanhuigu.jvm.memory
 * @date 2018/4/24 18:47
 * @version 1.0.0
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
