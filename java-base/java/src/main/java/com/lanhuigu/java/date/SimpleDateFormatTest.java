package com.lanhuigu.java.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yihonglei
 * @date 2018/3/22 9:26
 */
public class SimpleDateFormatTest {
    public static String datePattern = "yyyy-MM-dd";
    public static String strPattern = "yyyy年MM月dd日";

    public static void main(String[] args) throws ParseException {
        String date = stringToStringDate("2018-04-28", datePattern, strPattern);
        System.out.println("strDate:" + date);
    }

    public static String stringToStringDate(String stringDate, String datePattern, String strPattern) {
        SimpleDateFormat dfDate = new SimpleDateFormat(datePattern);
        SimpleDateFormat dfStr = new SimpleDateFormat(strPattern);
        try {
            Date date = dfDate.parse(stringDate);
            return dfStr.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
