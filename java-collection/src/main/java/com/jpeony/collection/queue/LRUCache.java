package com.jpeony.collection.queue;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 【题源】https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    int capacity = 0;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    /**
     * 查询缓存，没有则返回 -1
     */
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    /**
     * 插入缓存，当缓存满了，调用 removeEldestEntry() 判断是否要移出最久不使用的元素，
     * 需要则调用 removeNode() 移出最久元素，为新元素的插入预留空间。
     */
    public void put(int key, int value) {
        super.put(key, value);
    }

    /**
     * 是否要删除最近元素
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
