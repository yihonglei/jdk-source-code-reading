package com.jpeony.collection.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author yihonglei
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayQueue = new ArrayBlockingQueue<>(2);
        arrayQueue.offer("one");

        System.out.println(arrayQueue.take());
    }
}
