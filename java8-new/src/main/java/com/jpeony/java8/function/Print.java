package com.jpeony.java8.function;

/**
 * 函数接口
 */
@FunctionalInterface
interface Print<T> {
    void print(T x);
}

/**
 * Lambda表达式底层 基于内部类实现函数接口
 */
class Lambda {
    private static void printString(String s, Print<String> print) {
        print.print(s);
    }

    public static void main(String[] args) {
        printString("test", System.out::println);
    }
}
