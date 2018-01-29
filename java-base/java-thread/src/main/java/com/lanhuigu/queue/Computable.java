package com.lanhuigu.queue;

import java.util.concurrent.Future;

public interface Computable<A, V> {
    V compute(A args) throws InterruptedException;
}
