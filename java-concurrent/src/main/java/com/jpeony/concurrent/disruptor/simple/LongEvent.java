package com.jpeony.concurrent.disruptor.simple;

/**
 * 定义事件
 */
public class LongEvent {
    private long value;

    public void set(long value) {
        this.value = value;
    }
}
