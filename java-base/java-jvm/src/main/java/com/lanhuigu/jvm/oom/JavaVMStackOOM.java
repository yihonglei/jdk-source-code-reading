package com.lanhuigu.jvm.oom;

/**
 * 该段代码会导致操作系统假死，哈哈!!!
 * VM Args: -Xss2M
 * @author yihonglei
 * @date 2018/7/6 17:33
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
