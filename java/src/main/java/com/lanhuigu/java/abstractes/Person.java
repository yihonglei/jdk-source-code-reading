package com.lanhuigu.java.abstractes;

/**
 * 抽象类:不能用final修饰，
 * 可以包含抽象方法和非抽象方法，
 * 抽象方法没有方法体，只是定义功能，没有实现；
 * 非抽象方法为正常的方法。
 */
public abstract class Person {

    /**
     * abstract methods
     */
    public abstract String eat();

    public abstract String sleep();

    /**
     * non-abstract methods
     */
    public String sport() {
        return "生命在于运动";
    }
}
