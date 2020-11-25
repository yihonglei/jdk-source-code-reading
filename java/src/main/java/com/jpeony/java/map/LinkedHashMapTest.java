package com.jpeony.java.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yihonglei
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("one", "壹");
        linkedHashMap.put("two", "贰");

        for (Map.Entry entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
