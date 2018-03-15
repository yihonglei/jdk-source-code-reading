package com.lanhuigu.java8.ex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Test1
 * @Package: com.lanhuigu.java8.ex
 * @date 2018/3/10 21:31
 */
public class Test1 {
    public static void main(String[] args) {
        Trader raou1 = new Trader("Raou1", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raou1, 2012, 1000),
                new Transaction(raou1, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        List<Transaction> tr2011 =
                transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        tr2011.forEach(t -> System.out.println(t.getTrader().getName()));

    }
}
