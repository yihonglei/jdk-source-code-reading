package com.lanhuigu.thread.demo2;

/**
 * 竞态条件与临界区
 */
public class Counter {
    protected long count = 0;

    public void add(long value) {
        this.count = this.count + value;
    }

}
