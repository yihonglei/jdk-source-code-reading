package com.jpeony.collection.map;

import java.util.Collection;
import java.util.HashMap;

/**
 * 高性能，线程不安全
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();

        // 【demo1】简单测试 put() 和 get()
        hashMap.put("key1", "hello world!");
        hashMap.put("key1", "hello world2!");
        System.out.println(hashMap.get("key1"));

        hashMap.remove("key1");
        Collection<String> values = hashMap.values();
        for (String str : values) {
            System.out.println(str);
        }

        hashMap.putIfAbsent("", "");

        // 【demo2】测试 key 相同时，新值覆盖掉旧值
//        hashMap.put("key1", "hello world 1");
//        hashMap.put("key1", "hello world 2");

        // 【demo3】测试散列表扩容，添加第完13个数组位置时，进行数组扩容
//        hashMap.put("key1", "hello world 1");
//        hashMap.put("key2", "hello world 2");
//        hashMap.put("key3", "hello world 3");
//        hashMap.put("key4", "hello world 4");
//        hashMap.put("key5", "hello world 5");
//        hashMap.put("key6", "hello world 6");
//        hashMap.put("key7", "hello world 7");
//        hashMap.put("key8", "hello world 8");
//        hashMap.put("key9", "hello world 9");
//        hashMap.put("key10", "hello world 10");
//        hashMap.put("key11", "hello world 11");
//        hashMap.put("key12", "hello world 12");
//        hashMap.put("key13", "hello world 13");

    }
}
