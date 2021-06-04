package com.jpeony.collection.hash;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yihonglei
 */
public class SynchronizedMapTest {
    public static void main(String[] args) {
        Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap<>(16));
        synchronizedMap.put("key1", "sync1");
        synchronizedMap.put("key2", "sync2");
        synchronizedMap.put("key3", "sync3");
        for (String key : synchronizedMap.keySet()) {
            System.out.println("key= " + key + " and value = " + synchronizedMap.get(key));
        }
    }
}
