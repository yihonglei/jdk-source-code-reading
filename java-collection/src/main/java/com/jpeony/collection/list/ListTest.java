package com.jpeony.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

/**
 * ArrayList、LinkedList、Vector、Set
 *
 * @author yihonglei
 */
public class ListTest {
    public static void main(String[] args) {
        // ArrayList：非线程安全，元素有顺序，高效，可重复
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ooo");

        // Vector：线程安全，效率低
        Vector<String> vector = new Vector<>();

        // LinkedList：
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.addLast("");
        linkedList.addFirst("");
        linkedList.get(0);
        linkedList.remove("one");
    }
}
