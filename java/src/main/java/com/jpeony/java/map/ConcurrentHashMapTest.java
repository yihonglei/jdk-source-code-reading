package com.jpeony.java.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yihonglei
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap ch = new ConcurrentHashMap();
        ch.put("hh", "jj");
        ch.get("hh");
    }
}
