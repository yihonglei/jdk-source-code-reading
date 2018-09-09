package com.lanhuigu.jvm.loadclass;

/**
 * 非主动使用类字段演示
 * @author yihonglei
 * @date 2018/4/29 22:35
 */
public class NotInitilizationThree {
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORD);
    }
}
