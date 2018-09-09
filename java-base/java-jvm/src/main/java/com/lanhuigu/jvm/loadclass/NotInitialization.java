package com.lanhuigu.jvm.loadclass;

/**
 * 通过子类引用父类的静态字段，不会导致子类初始化
 * @author yihonglei
 * @date 2018/4/29 22:08
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
