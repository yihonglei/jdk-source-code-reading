package com.jpeony.collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yihonglei
 */
public class ArrayDequeTest {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        // 入栈
        stack.push("a");
        // 获取栈顶元素
        String peek = stack.peek();
        System.out.println("peek = " + peek);
        // 栈顶元素出栈
        stack.pop();
        // 判断栈是否为空
        System.out.println("isEmpty = " + stack.isEmpty());
    }
}
