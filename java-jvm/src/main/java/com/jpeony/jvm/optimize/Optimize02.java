package com.jpeony.jvm.optimize;

/**
 * 【尽可能使用局部变量】
 * 调用方法时传递的参数以及在调用中创建的临时变量都保存在栈中速度较快，其他变量，如静态变量、实例变量等，
 * 都在堆中创建，速度较慢。另外，栈中创建的变量，随着方法的运行结束，这些内容就没了，不需要额外的垃圾回收。
 *
 * @author yihonglei
 */
public class Optimize02 {
    private Integer i = 0;

    public void hello() {
        hello1();

        hello2();

        hello3();
    }

    private void hello1() {
        i = i + 100;
    }

    private void hello2() {
        i = i + 200;
    }

    private void hello3() {
        i = i + 300;
    }
}
