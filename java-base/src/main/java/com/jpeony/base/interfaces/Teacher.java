package com.jpeony.base.interfaces;

/**
 * 接口的具体实现
 *
 * @author yihonglei
 */
public class Teacher implements Person {

    @Override
    public String eat() {
        return "老师吃饭";
    }

    @Override
    public String sleep() {
        return "老师睡觉";
    }

}