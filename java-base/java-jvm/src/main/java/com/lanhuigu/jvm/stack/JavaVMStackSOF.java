package com.lanhuigu.jvm.stack;

/**
 * VM Args: -Xss128k
 * @author yihonglei
 * @ClassName: JavaVMStackSOF
 * @Package: com.lanhuigu.jvm.stack
 * @date 2018/4/24 19:32
 * @version 1.0.0
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
