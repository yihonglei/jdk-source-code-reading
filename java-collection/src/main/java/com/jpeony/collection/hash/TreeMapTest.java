package com.jpeony.collection.hash;

import java.util.TreeMap;

/**
 * @author yihonglei
 */
public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>();

        treeMap.put("key1", "value1");

        System.out.println(treeMap.get("key1"));
    }
}
