package com.lanhuigu.queue;

import java.math.BigInteger;

public class ExpensiveFunction implements Computable<String, BigInteger> {

    @Override
    public BigInteger compute(String args) throws InterruptedException {
        return new BigInteger(args);
    }
}
