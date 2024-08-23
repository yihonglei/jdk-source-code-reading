package com.jpeony.collection.map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 1、Map接口常用实现类：HashMap、Hashtable、LinkedHashMap、SynchronizedMap、ConcurrentHashMap等
 * 2、HashMap 非线程安全，高效，key支持null，value支持null；
 * 3、Hashtable HashTable线程安全，低效，key不支持null，value不支持null；
 * 4、LinkedHashMap 类似于HashMap，但是迭代遍历时，取得“键值对”的顺序是其插入次，比HashMap慢一点；
 * 5、SynchronizedMap 线程安全，是对Map进行线程安全包装，key是否允许为空，取决于用的Map实现；
 * 6、ConcurrentHashMap 线程安全，分段锁，高效，key不支持null，value不支持null；
 * 7、Map提供key到value的映射,一个Map中不能包含相同key，每个key只能映射一个value；
 */
public class HashTest {
    private final static Logger logger = LoggerFactory.getLogger(HashTest.class);

    public static void main(String[] args) {
        // 1、HashMap：非线程安全，高效，key支持null，value支持null
        logger.info("HashMap start ......");
        Map<String, String> hashMap = new HashMap<String, String>();
        // hashMap.put(key, value);
        hashMap.put("1", "one");
        hashMap.put("2", "two");
        hashMap.put("3", "three");
        // key,value支持null
        hashMap.put(null, null);

        for (String key : hashMap.keySet()) {
            System.out.println("key= " + key + " and value = " + hashMap.get(key));
        }
        logger.info("HashMap end!!!!!!");
        // 2、HashTable：HashTable线程安全，低效，key不支持null，value不支持null
        logger.info("HashTable start ......");
        Map<String, String> hashTable = new Hashtable<String, String>();
        //hashTable.put(key, value)
        hashTable.put("1", "a");
        hashTable.put("2", "b");
        hashTable.put("3", "c");
//        hashTable.put(null, null); //如果加上这一行null，HashTable报错，key，value都不支持null

        for (String key : hashTable.keySet()) {
            System.out.println("key= " + key + " and value = " + hashTable.get(key));
        }
        logger.info("HashTable end!!!!!!");
        // 3、LinkedHashMap：类似于HashMap，但是迭代遍历时，取得“键值对”的顺序是其插入次，比HashMap慢一点。
        logger.info("LinkedHashMap start ......");
        Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        // hashMap.put(key, value);
        linkedHashMap.put("1", "lkhm1");
        linkedHashMap.put("2", "lkhm2");
        linkedHashMap.put("3", "lkhm3");
        // key,value支持null
        linkedHashMap.put(null, null);

        for (String key : linkedHashMap.keySet()) {
            System.out.println("key= " + key + " and value = " + linkedHashMap.get(key));
        }
        logger.info("LinkedHashMap end!!!!!!");
        // 4、SynchronizedMap：线程安全，是对Map进行线程安全包装，key是否允许为空，取决于用的Map实现
        logger.info("SynchronizedMap start ......");
        Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap<>(16));
        synchronizedMap.put("1", "sync1");
        synchronizedMap.put("2", "sync2");
        synchronizedMap.put("3", "sync3");
        for (String key : synchronizedMap.keySet()) {
            System.out.println("key= " + key + " and value = " + synchronizedMap.get(key));
        }
        logger.info("SynchronizedMap end!!!!!!");

        // 5、ConcurrentHashMap：jdk1.7 线程安全，分段锁，高效，key不支持null，value不支持null
        // jdk1.8 线程安全 cas + synchronized，高效，key不支持null，value不支持null
        logger.info("ConcurrentHashMap start ......");
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>(16);
        concurrentHashMap.put("1", "conc1");
        concurrentHashMap.put("2", "conc2");
        concurrentHashMap.put("3", "conc3");
        for (String key : concurrentHashMap.keySet()) {
            System.out.println("key= " + key + " and value = " + concurrentHashMap.get(key));
        }
        logger.info("ConcurrentHashMap end!!!!!!");
    }
}