package com.jpeony.base.string;

/**
 * 线程安全
 */
public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();

        sb.append("a");
        sb.append("b");
        sb.append("c");
        sb.append("d");

        System.out.println(sb.toString());
    }
}
