package com.jpeony.collection.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author yihonglei
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(6);
        list.add(5);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("element[" + i + "] = " + list.get(i));
        }

        System.out.println("=== sort ===");
        // ComparableTimSort.sort 逻辑
        list.sort(null);
        // TimSort.sort 逻辑
        list.sort(new ListComparator());

        for (int i = 0; i < list.size(); i++) {
            System.out.println("element[" + i + "] = " + list.get(i));
        }

    }

    private static class ListComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return Integer.parseInt(o1.toString()) - Integer.parseInt(o2.toString());
        }
    }
}
