package com.jpeony.base.finals;

public class FinalArgumentsTest {
    public static void main(String[] args) {

    }
}

class MyArgumentsClass {
    public void sayAge(final int age) {
//         age++;
        System.out.println(age);
    }
}
