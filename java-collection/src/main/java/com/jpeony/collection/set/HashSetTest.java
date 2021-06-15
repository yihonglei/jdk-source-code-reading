package com.jpeony.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * 存放不重复对象。
 *
 * @author yihonglei
 */
public class HashSetTest {
    public static void main(String[] args) {
        // add
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");

        // remove
        set.remove("e");

        // print
        for (String str : set) {
            System.out.println(str);
        }
    }
}
