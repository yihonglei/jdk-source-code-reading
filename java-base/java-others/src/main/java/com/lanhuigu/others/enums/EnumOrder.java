package com.lanhuigu.others.enums;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: EnumOrder
 * @Package: com.lanhuigu.others.enums
 * @date 2018/4/9 11:40
 */
public class EnumOrder {
    public static void main(String[] args) {
        for (Spiciness s : Spiciness.values()) {
            System.out.println(s + ", ordinal " + s.ordinal());
        }
    }
}
