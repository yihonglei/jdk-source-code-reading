package com.jpeony.java.map;

import java.util.Hashtable;

/**
 * synchronized 实现线程安全，并发度低
 *
 * @author yihonglei
 */
public class HashTableTest {
    public static void main(String[] args) {
        Hashtable<String, String> hashTable = new Hashtable<>();

        hashTable.put("key1", "hello world!");

        System.out.println(hashTable.get("key1"));
    }
}
