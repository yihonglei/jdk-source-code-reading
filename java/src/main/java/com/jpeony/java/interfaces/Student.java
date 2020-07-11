package com.jpeony.java.interfaces;

/**
 * 接口的具体实现
 */
public class Student implements Person {

    @Override
    public String eat() {
        return "学生吃饭";
    }

    @Override
    public String sleep() {
        return "学生睡觉";
    }

}
