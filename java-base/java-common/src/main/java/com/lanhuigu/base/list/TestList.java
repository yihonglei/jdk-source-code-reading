package com.lanhuigu.base.list;

import java.util.ArrayList;

public class TestList {

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();

        a.add("a");
        a.add(0, "b");

        for (int i = 0; i < a.size(); i ++) {
            System.out.println(a.get(i));
        }
    }
}
