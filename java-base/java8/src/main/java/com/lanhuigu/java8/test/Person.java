package com.lanhuigu.java8.test;

/**
 * @author yihonglei
 * @date 2018/12/4 10:06
 */
public abstract class Person {
    protected abstract void eat();

    abstract void sleep();

    protected void doSome() {

    }

    public static class Childeren extends Person {
        protected void eat() {
            System.out.println("=eat");
        }

        public void sleep() {

        }
    }


    public static void main(String[] args) {
        Childeren c = new Childeren();

        c.eat();
    }
}
