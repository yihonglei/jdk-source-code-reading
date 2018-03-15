package com.lanhuigu.java8.ex;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.ex
 * @date 2018/3/10 21:26
 */
public class Trader {
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
