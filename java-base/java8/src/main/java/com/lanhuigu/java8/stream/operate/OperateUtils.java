package com.lanhuigu.java8.stream.operate;

import java.util.Arrays;
import java.util.List;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: OperateUtils
 * @Package: com.lanhuigu.java8.stream.operate
 * @date 2018/6/16 13:08
 */
public class OperateUtils {

    /**
     * 初始化交易List
     */
    public static List<Transaction> initTransactions() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        return transactions;
    }

}
