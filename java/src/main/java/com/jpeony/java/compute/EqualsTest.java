package com.jpeony.java.compute;

/**
 * ==和equals()的区别:
 * (1)==相同对象的相同内容时为true,否则为false
 * (2)相同或不同对象的相同内容为true,否则为false
 *
 * @author yihonglei
 */
public class EqualsTest {
    public static void main(String[] args) {
        // 创建两个不同对象t1、t2,但是内容相同均为1
        Integer t1 = new Integer(1);
        Integer t2 = new Integer(1);

        // Test
        System.out.println(t1 == t2);// false
        System.out.println(t1.equals(t2));// true
    }
}
