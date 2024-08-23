package com.jpeony.concurrent.threadlocal;

/**
 * 重写ThreadLocal初始化方法，自定义初始值
 */
public class ThreadLocalExt extends ThreadLocal {

    @Override
    protected Object initialValue() {
        // return super.initialValue();
        return "设置默认值，第一次获取不在为null";
    }

}
