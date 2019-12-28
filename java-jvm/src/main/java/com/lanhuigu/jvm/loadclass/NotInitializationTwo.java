package com.lanhuigu.jvm.loadclass;

/**
 * 通过数组定义来引用类，不会触发此类的初始化
 *
 * @author yihonglei
 */
public class NotInitializationTwo {
    public static void main(String[] args) {
        SuperClass[] sca = new SuperClass[10];
    }
}
