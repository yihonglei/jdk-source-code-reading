package com.jpeony.jvm.oom;

/**
 * 【Java虚拟机栈 OutOfMemoryError 异常演示】该段代码会导致操作系统假死，哈哈!!!
 * VM Args: -Xss2M
 *
 * @author yihonglei
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> dontStop());
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
