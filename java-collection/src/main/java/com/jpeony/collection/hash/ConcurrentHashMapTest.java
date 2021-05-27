package com.jpeony.collection.hash;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 分段锁，高并发，高性能，线程安全
 *
 * @author yihonglei
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> conMap = new ConcurrentHashMap<>();

        conMap.put("key1", "hello world!");
        conMap.put("key1", "hello world!");
        System.out.println(conMap.get("key1"));
    }
}
