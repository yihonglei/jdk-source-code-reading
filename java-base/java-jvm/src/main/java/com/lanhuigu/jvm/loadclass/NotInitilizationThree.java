package com.lanhuigu.jvm.loadclass;

/**
 * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。
 * @author yihonglei
 * @ClassName: NotInitilizationThree
 * @Package: com.lanhuigu.jvm.loadclass
 * @date 2018/4/29 22:35
 * @version 1.0.0
 */
public class NotInitilizationThree {
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORD);
    }
}
