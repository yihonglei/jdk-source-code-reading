package com.jpeony.base.finals;

/**
 * @author yihonglei
 */
public class ObjectContentTest {
    public static void main(String[] args) {
        final MyClass myClass = new MyClass();
        System.out.println(++myClass.i);
    }
}

class MyClass {
    int i = 0;
}
