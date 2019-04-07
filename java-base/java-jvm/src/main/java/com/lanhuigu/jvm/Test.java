package com.lanhuigu.jvm;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yihonglei
 * @ClassName: Test
 * @Package: com.lanhuigu.jvm
 * @date 2018/5/1 20:04
 * @version 1.0.0
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000000);

        List<String> listR = new ArrayList<>();

        listR.add("1");
        listR.add("2");
        listR.add("3");

        for (int i = 0;i < listR.size(); i++) {
            if (listR.get(i).equals("2")) {
                listR.remove(i);
            }
        }

        System.out.println("==============");
        for (String str : listR) {
            System.out.println(str);
        }
    }
}
