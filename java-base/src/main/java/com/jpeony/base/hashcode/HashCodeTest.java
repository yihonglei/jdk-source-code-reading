package com.jpeony.base.hashcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yihonglei
 */
public class HashCodeTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(11);
        list.add(13);
        list.add(15);

        for (int i = 0; i < list.size(); i++) {
            Integer id = list.get(i);

            int i1 = System.identityHashCode(id);
            System.out.println(i1);
            System.out.println(i1 % 2);
        }
    }
}
