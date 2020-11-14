package com.jpeony.java.map;

import java.util.HashMap;

/**
 * 高性能，线程不安全
 *
 * @author yihonglei
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("key1", "hello world!");

        System.out.println(hashMap.get("key1"));
    }
}
