package com.jpeony.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 1、List为继承于Collection的一个子接口（可查看源码）
 * 2、List元素有放入顺序，可重复
 * 3、常用实现类（ArrayList，LinkedList，Vector，CopyOnWriteArrayList）
 * <p>
 * ArrayList 非线程安全，效率高；
 * LinkedList 底层基于链表实现，结构散乱；
 * Vector 线程安全，效率低；
 * CopyOnWriteArrayList 特征：线程安全、读写分离场景，高效；
 */
public class ListTest {
    public static void main(String[] args) {
        /*
         * ArrayList
         * 【数据结构】
         *  底层基于数组实现。
                * 【特性】
         *  支持根据下标随机访问时间复杂度 O(1)，插入和删除时间复杂度 O(n)，因为要进行数据元素搬移；
         *  非线程安全，元素有序，可以重复；
         */
        ArrayList<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        list.add("d");
        for (String s : list) {
            System.out.println("ArrayList:" + s);
        }
        /*
         * LinkedList
         * 【数据结构】
         *  底层基于双向链表实现。
                * 【特性】
         * 插入和删除时间复杂度 O(1)，不支持随机查找元素，元素查找需要遍历链表，时间复杂度 O(n)
         */
        LinkedList<String> list2 = new LinkedList();
        list2.add("a2");
        list2.add("b2");
        list2.add("c2");
        list2.add("d2");

        for (String s : list2) {
            System.out.println("LinkedList:" + s);
        }
        /*
         * Vector
         * 【数据结构】
         * 底层基于数组实现。
                * 【特性】
         *  synchronized 加锁保证线程安全，低效。
         */
        Vector<String> list3 = new Vector();
        list3.add("a3");
        list3.add("b3");
        list3.add("c3");
        list3.add("d3");

        for (String s : list3) {
            System.out.println("Vector:" + s);
        }
        /*
         * CopyOnWriteArrayList
         * 【数据结构】
         * 底层基于数组实现。
                * 【特性】
         *  线程安全、读写分离场景，用于读多写少场景；
         */
        List<String> list4 = new CopyOnWriteArrayList<>();
        list4.add("a1");
        list4.add("a2");
        list4.add("a3");
        list4.add("a4");
        for (String s : list4) {
            System.out.println("CopyOnWriteArrayList:" + s);
        }
    }
}
