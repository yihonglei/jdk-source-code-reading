package com.jpeony.collection.map;

import java.util.Hashtable;

/**
 * synchronized 实现线程安全，并发度低
 */
public class HashTableTest {
    public static void main(String[] args) {
        Hashtable<String, String> hashTable = new Hashtable<>();
        for (int i = 0; i < 200; i++) {
            hashTable.put("key" + i, "hello world!");
        }

        System.out.println(hashTable.get("key1"));
    }
}
