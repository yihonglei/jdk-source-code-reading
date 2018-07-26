package com.lanhuigu.thread.threadmgmt;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

public class MultiThread {
    public static void main(String[] args) {
        // 获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        Arrays.stream(threadInfos).forEach(threadInfo -> {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        });
    }
}
