package com.lanhuigu.java8.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.date
 * @date 2018/3/16 11:29
 */
public class DateUtils {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(1018, 3, 16);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();
    }
}
