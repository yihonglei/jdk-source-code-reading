package com.jpeony.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yihonglei
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");

        for (int i = 0; i < list.size(); i++) {
            System.out.println("element[" + i + "] = " + list.get(i));
        }
    }
}
