package com.lanhuigu.java8.stream.operate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Demo01Test
 * @Package: com.lanhuigu.java8.stream.operate
 * @date 2018/6/16 13:07
 */
public class Demo01Test {
    public static void main(String[] args) {
        List<Transaction> transactions = OperateUtils.initTransactions();
        List<Transaction> tr2011 =
                transactions.stream()
                            .filter(transaction -> transaction.getValue() == 2011)
                            .sorted(Comparator.comparing(Transaction::getValue))
                            .collect(Collectors.toList());

        System.out.println(tr2011);
    }
}
