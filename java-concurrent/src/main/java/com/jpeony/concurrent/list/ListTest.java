package com.jpeony.concurrent.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 1、List为继承于Collection的一个子接口（可查看源码）
 * 2、List元素有放入顺序，可重复
 * 3、常用实现类（ArrayList，LinkedList，Vector，CopyOnWriteArrayList）
 * ArrayList 非线程安全，效率高；
 * LinkedList 底层基于链表实现，结构散乱；
 * Vector 线程安全，效率低；
 * CopyOnWriteArrayList 特征：线程安全、读写分离场景，高效；
 *
 * @author yihonglei
 */
public class ListTest {
    public static void main(String[] args) {
        // 1、ArrayList 特征：非线程安全，元素有顺序，高效，可重复
        ArrayList<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        // 可以重复检测
        list.add("d");
        // 循环输出list中的元素，下表从0开始
        for (String s : list) {
            System.out.println("ArrayList:" + s);
        }
        // 2、LinkedList底层基于链表实现，结构散乱，每一个元素存储本身地址的同时还存下一个元素的地址。 特征：链表增删快，查找慢。
        LinkedList<String> list2 = new LinkedList();
        list2.add("a2");
        list2.add("b2");
        list2.add("c2");
        list2.add("d2");
        // 循环输出list2中的元素，下标从0开始
        for (String s : list2) {
            System.out.println("LinkedList:" + s);
        }
        // 3、Vector 特征：线程安全，低效。
        Vector<String> list3 = new Vector();
        list3.add("a3");
        list3.add("b3");
        list3.add("c3");
        list3.add("d3");
        // 循环输出list3中的元素，下标从0开始
        for (String s : list3) {
            System.out.println("Vector:" + s);
        }
        // 4、CopyOnWriteArrayList 特征：线程安全、读写分离场景，高效。
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
