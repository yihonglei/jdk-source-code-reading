package com.jpeony.collection.list;

import java.util.Vector;

/**
 * @author yihonglei
 */
public class VectorTest {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();

        vector.add(1);
        vector.add(2);
        vector.add(3);

        for (Integer e : vector) {
            System.out.println(e);
        }
    }
}
