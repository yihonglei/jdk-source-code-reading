package com.jpeony.base.abstractes;


/**
 * 继承于抽象类person，必须实现父类中的所有抽象方法
 *
 * @author yihonglei
 */
public class Student extends Person {

    @Override
    public String eat() {
        return "学生吃饭";
    }

    @Override
    public String sleep() {
        return "学生睡觉";
    }

}
