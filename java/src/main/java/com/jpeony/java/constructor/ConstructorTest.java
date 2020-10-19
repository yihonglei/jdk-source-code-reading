package com.jpeony.java.constructor;

/**
 * @author yihonglei
 */
public class ConstructorTest {
    /**
     * 默认构造器，一般创建类时，自带，不需要我们写出来
     */
    public ConstructorTest() {
        System.out.println("默认构造器");
    }
    /*
     * 有参构造器，可以根据不同参数，创建不同的构造器，有实际需要时在创建
     */

    /**
     * 有参构造器one
     */
    public ConstructorTest(int i) {
        System.out.println("有参构造器one,初始化对象时传入的参数为:" + i);
    }

    /**
     * 有参构造器two
     */
    public ConstructorTest(String paramName) {
        System.out.println("有参构造器two,初始化对象时传入的参数为:" + paramName);
    }

    /**
     * Test，运行main方法，根据不同的构造器，创建3个不同的对象
     */
    public static void main(String[] args) {
        ConstructorTest c1 = new ConstructorTest();
        ConstructorTest c2 = new ConstructorTest(1);
        ConstructorTest c3 = new ConstructorTest("this is my constructor!");
        System.out.println("简单测试一下创建出来的对象是不一样的，输出false---" + (c1 == c2));
    }
}
