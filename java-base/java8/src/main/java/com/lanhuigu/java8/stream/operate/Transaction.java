package com.lanhuigu.java8.stream.operate;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Transaction
 * @Package: com.lanhuigu.java8.stream.operate
 * @date 2018/6/16 13:07
 */
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;
    public Transaction(Trader trader, int year, int value){
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    public Trader getTrader(){
        return this.trader;
    }
    public int getYear(){
        return this.year;
    }
    public int getValue(){
        return this.value;
    }
    @Override
    public String toString(){
        return "{" + this.trader + ", " +
                "year: "+this.year+", " +
                "value:" + this.value +"}";
    }
}
