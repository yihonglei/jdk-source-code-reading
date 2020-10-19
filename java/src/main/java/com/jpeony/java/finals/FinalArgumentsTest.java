package com.jpeony.java.finals;

/**
 * @author yihonglei
 */
public class FinalArgumentsTest {
    public static void main(String[] args) {

    }
}

class MyArgumentsClass {
    public void sayAge(final int age) {
        // age++;
        System.out.println(age);
    }
}
