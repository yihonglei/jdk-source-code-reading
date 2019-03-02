package com.lanhuigu.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 测试自定义并发包
 *
 * @author yihonglei
 * @date 2019/3/2 11:35
 */
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(4, 6, new LinkedBlockingQueue<>());

        threadPoolExecutor.execute(() -> {
            System.out.println("run-begin");
            System.out.println("run-end");
        });
    }
}
