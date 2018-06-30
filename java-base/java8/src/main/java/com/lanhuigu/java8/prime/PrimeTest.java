package com.lanhuigu.java8.prime;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: PrimeTest
 * @Package: com.lanhuigu.java8.prime
 * @date 2018/6/28 13:55
 */
public class PrimeTest {
    public static void main(String[] args) {
        System.out.println(partitionPrimes(10));
        System.out.println(partitionPrimes(10).get(true));
        System.out.println(partitionPrimes(10).get(false));
    }

    /**
     * 分区
     */
    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
    }

    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

}
