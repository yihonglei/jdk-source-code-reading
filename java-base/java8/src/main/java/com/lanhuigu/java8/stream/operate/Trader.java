package com.lanhuigu.java8.stream.operate;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Trader
 * @Package: com.lanhuigu.java8.stream.operate
 * @date 2018/6/16 13:06
 */
public class Trader {
    private final String name;
    private final String city;
    public Trader(String n, String c){
        this.name = n;
        this.city = c;
    }
    public String getName(){
        return this.name;
    }
    public String getCity(){
        return this.city;
    }
    @Override
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}
