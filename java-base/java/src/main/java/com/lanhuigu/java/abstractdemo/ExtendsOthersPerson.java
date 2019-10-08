package com.lanhuigu.java.abstractdemo;


/**
 * 必须实现抽象父类OthersPerson，以及OthersPerson父类Person中
 * 的所有抽象方法，新帐旧账一起算。
 */
public class ExtendsOthersPerson extends OthersPerson {

    @Override
    public String sleep() {
        return "睡觉";
    }

    @Override
    public String eat() {
        return "吃饭";
    }

    @Override
    public String call() {
        return "打电话";
    }

}
