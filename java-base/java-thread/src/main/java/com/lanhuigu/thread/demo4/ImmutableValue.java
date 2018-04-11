package com.lanhuigu.thread.demo4;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: ImmutableValue
 * @Package: com.lanhuigu.thread.demo4
 * @date 2018/4/10 20:41
 */
public class ImmutableValue {
    private int value = 0;

    public ImmutableValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
