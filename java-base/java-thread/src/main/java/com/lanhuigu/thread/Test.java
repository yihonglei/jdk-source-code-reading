package com.lanhuigu.thread;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Test
 * @Package: com.lanhuigu.thread
 * @date 2018/4/13 23:10
 */
public class Test {
    public static void main(String[] args) {
        String ip = "111.202.106.154, 100.116.224.89";
        String[] arrTmp = ip.split(",");
        System.out.println(arrTmp[0]);
    }
}
