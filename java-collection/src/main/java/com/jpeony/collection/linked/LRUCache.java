package com.jpeony.collection.linked;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 【题源】https://leetcode-cn.com/problems/lru-cache/
 *
 * @author yihonglei
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    int capacity = 0;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
