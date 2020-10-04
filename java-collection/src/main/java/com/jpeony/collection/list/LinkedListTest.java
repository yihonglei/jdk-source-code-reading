package com.jpeony.collection.list;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yihonglei
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        list.add("one");
        list.add("two");
        list.add("three");

        for (int i = 0; i < list.size(); i++) {
            System.out.println("element[" + i + "] " + list.get(i));
        }
    }
}
