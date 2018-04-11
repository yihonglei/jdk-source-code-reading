package com.lanhuigu.others;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Test
 * @Package: com.lanhuigu.others
 * @date 2018/3/22 9:26
 */
public class Test {
    public static void main(String[] args) {
        long defaultScore = 0;
        String idNum = "522324199112084010";
        int leh = idNum.length();
        String dates = "";
        if (leh == 18) {
            dates = idNum.substring(6, 10);
            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            String year = df.format(new Date());
            defaultScore = Integer.parseInt(year) - Integer.parseInt(dates);
        } else {
            dates = idNum.substring(6, 8);
            defaultScore = Integer.parseInt(dates);
        }

        System.out.println("defaultScore;" + defaultScore);
    }
}
