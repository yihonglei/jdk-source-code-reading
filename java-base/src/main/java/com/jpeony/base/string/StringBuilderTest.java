package com.jpeony.base.string;

/**
 * 非线程安全
 *
 * @author yihonglei
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        sb.append("a");
        sb.append("b");
        sb.append("c");
        sb.append("d");

        System.out.println(sb.toString());
    }
}
