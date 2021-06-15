package com.jpeony.collection.queue;

import java.util.PriorityQueue;

/**
 * 优先队列
 *
 * @author yihonglei
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();

        queue.add("one");
        queue.add("two");

        System.out.println(queue.peek());
    }
}
