package com.jpeony.jvm.optimize;

import com.jpeony.jvm.engine.ExecuteEngine;

/**
 * 【不要创建一些不使用的对象，不要导入一些不使用的类】
 *
 * @author yihonglei
 */
public class Optimize07 {

    public static void main(String[] args) {
        ExecuteEngine test = new ExecuteEngine();

        System.out.println("hello world!");
    }
}
