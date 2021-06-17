package com.jpeony.java.string;

/**
 * 线程安全
 *
 * @author yihonglei
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
