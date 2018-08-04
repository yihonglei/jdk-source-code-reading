package com.lanhuigu.thread.aqs;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

/**
 * Java天生支持多线程，并不是一个人在战斗
 */
public class MultiThread {
    public static void main(String[] args) {
        // 获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的monitor和synchronized信息，仅获取线程和线程堆信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程id和线程名称
        Arrays.asList(threadInfos).parallelStream().forEach(threadInfo -> {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        });
    }
}
