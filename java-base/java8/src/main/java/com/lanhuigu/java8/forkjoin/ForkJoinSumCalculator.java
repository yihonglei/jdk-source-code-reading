package com.lanhuigu.java8.forkjoin;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: ForkJoinSumCalculator
 * @Package: com.lanhuigu.java8.forkjoin
 * @date 2018/6/28 18:54
 */
public class ForkJoinSumCalculator extends RecursiveTask{// 继承RecursiveTask来创建可以用于分支/合并框架的任务

    /** 要求和的数组 */
    private final long[] numbers;

    /** 子任务的起始和终止位置 */
    private final int start;
    private final int end;

    /** 不再将任务分解为子任务的数组大小 */
    public static final long THRESHOLD = 10_000;

    /**
     * 公共构造函数用于创建主任务
     */
    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    /**
     * 覆盖RecursiveTask的抽象方法
     */
    @Override
    protected Long compute() {
        // 该任务负责求和的任务的大小
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }

        ForkJoinSumCalculator leftTask =
                new ForkJoinSumCalculator(numbers, start, start + length/2);
        leftTask.fork();

        ForkJoinSumCalculator rightTask =
                new ForkJoinSumCalculator(numbers, start + length/2, end);

        Long rightResult =  rightTask.compute();
        Long leftResult = (Long) leftTask.join();
        return  leftResult + rightResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i ++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n) {
        // 创建要求和的数组
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        // 创建分支任务
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        // 创建ForkJoinPool线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 任务提交线程池并执行
        return forkJoinPool.invoke(task);
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        System.out.println(forkJoinSum(100000000));
    }
}
