package com.lanhuigu.java8;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.stream.LongStream;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: TestTwo
 * @Package: com.lanhuigu.java8
 * @date 2018/6/28 15:51
 */
public class TestTwo {
    public static void main(String[] args) {
        System.out.println(sideEffectSum(10_000_000L));
    }

    /*public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    static class Accumulator {
        public long total = 0;
        public void add(long value) { total += value; }
    }*/

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    /**
     * 该段代码为非线程安全的，不是一个原子操作，并发情况下，数据会被篡改。
     * 如果要保证数据安全，可以加同步锁，但是如果加同步锁，就是去了并发的意义。
     */
    static class Accumulator {
        public long total = 0;
        public void add(long value) {
            total += value;
        }
    }

}
