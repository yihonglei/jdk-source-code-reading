package com.lanhuigu.thread.demo6;

/**
 * @author yihonglei
 * @ClassName: RunTest
 * @Package: com.lanhuigu.thread.demo6
 * @date 2018/4/14 13:26
 * @version 1.0.0
 */
public class RunTest {
    private static ThreadLocal tl = new ThreadLocal();

    public static void main(String[] args) {
        if (tl.get() == null) {
            System.out.println("未放入过值");
            tl.set("放入值");
        }

        System.out.println("从ThreadLocal中获取值:" + tl.get());
    }
}
