package com.lanhuigu.safe;

import java.util.concurrent.atomic.AtomicInteger;

public class NumberRange {
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void setLower(int i) {
        if (i > upper.get()) {
            lower.set(i);
        }
    }

    public void setUpper(int i) {
        if (i < lower.get()) {
            upper.set(i);
        }
    }

    public boolean isInRange(int i) {
        return (i >=  lower.get()) && i <= upper.get();
    }

}
