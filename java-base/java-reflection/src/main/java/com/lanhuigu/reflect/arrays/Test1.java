package com.lanhuigu.reflect.arrays;

import java.lang.reflect.Array;

public class Test1 {
    public static void main(String[] args) {
        int[] intArray = (int[]) Array.newInstance(int.class, 3);
        Array.set(intArray, 0, 100);
        Array.set(intArray, 1, 200);
        Array.set(intArray, 2, 300);
        System.out.println("intArray[0] = " + Array.get(intArray, 0));
        System.out.println("intArray[1] = " + Array.get(intArray, 1));
        System.out.println("intArray[2] = " + Array.get(intArray, 2));
    }
}
