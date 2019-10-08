package com.lanhuigu.java.compute;

/**
 * +连接不同的字符串
 */
public class MyPlusSign {
    public static void main(String[] args) {
        //1、从左边开始算起，1+1为2，当遇到字符串时，自动转换成字符串连接
        System.out.println(1 + 1 + "this is my test" + 1 + 1 + "!");

        //2、从左边开始，右边遇到左边的字符串自动转换成字符串连接
        System.out.println("this is my test" + 1 + 1 + 1 + "!");
    }
}