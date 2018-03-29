package com.lanhuigu.others;

import java.math.BigDecimal;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Test
 * @Package: com.lanhuigu.others
 * @date 2018/3/22 9:26
 */
public class Test {
    public static void main(String[] args) {
        BigDecimal b = BigDecimal.valueOf(0.12).divide(BigDecimal.valueOf(12), 2, BigDecimal.ROUND_DOWN);
        System.out.println(b);

        /*BigDecimal decimal = new BigDecimal("1.12345");
        System.out.println(decimal);
        BigDecimal setScale = decimal.setScale(4,BigDecimal.ROUND_HALF_DOWN);
        System.out.println(setScale);

        BigDecimal setScale1 = decimal.setScale(4,BigDecimal.ROUND_HALF_UP);
        System.out.println(setScale1);*/
    }
}
