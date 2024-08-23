package com.jpeony.base.string;

/**
 * ==号比较堆地址是否相同，相同为true，否则为 false
 * equals 比较堆地址对应的值是否相同，相同为true，否则为 false
 */
public class StringTest {
    public static void main(String[] args) {
        // +号分析
        String sAdd1 = "ab";
        String sAdd2 = "cd";
        String sAdd3 = sAdd1 + sAdd2;
        String sAdd4 = "abcd";
        System.out.println(sAdd3);// abcd
        System.out.println(sAdd3 == sAdd4);// false

        // ==号分析
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);// true
        System.out.println(s1.equals(s2));// true

        // equals分析
        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s3 == s4);// false
        System.out.println(s3.equals(s4));// true
    }
}
