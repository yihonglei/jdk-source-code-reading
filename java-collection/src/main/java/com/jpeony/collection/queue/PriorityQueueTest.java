package com.jpeony.collection.queue;

import java.util.PriorityQueue;

/**
 * 优先队列
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 入队
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(4);
        queue.offer(5);
        // 返回队头元素
        System.out.println("peek = " + queue.peek());
        // 出队
        for (int i = 0; i < 5; i++) {
            System.out.println("poll = " + queue.poll());
        }
    }
}
