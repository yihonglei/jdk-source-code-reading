package com.jpeony.java.abstractes;

/**
 * 继承于抽象类person,必须实现父类中的所有抽象方法
 *
 * @author yihongeli
 */
public class Teacher extends Person {

    @Override
    public String eat() {
        return "老师吃饭";
    }

    @Override
    public String sleep() {
        return "老师睡觉";
    }

}
