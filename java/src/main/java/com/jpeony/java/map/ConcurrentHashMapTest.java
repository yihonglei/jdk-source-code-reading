package com.jpeony.java.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap ch = new ConcurrentHashMap();
        ch.put("hh", "jj");
        ch.get("hh");
    }
}
