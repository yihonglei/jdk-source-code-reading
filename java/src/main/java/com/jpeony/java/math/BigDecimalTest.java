package com.jpeony.java.math;

import java.math.BigDecimal;

/**
 * @author yihonglei
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        int travelTime = 3743023;
        BigDecimal travelTimeB = BigDecimal.valueOf(travelTime);
        Integer travelTimeMinutes = travelTimeB.divide(BigDecimal.valueOf(60000), BigDecimal.ROUND_HALF_UP).intValue();

        System.out.println(travelTimeMinutes);
    }
}
