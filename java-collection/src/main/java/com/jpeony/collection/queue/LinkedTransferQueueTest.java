package com.jpeony.collection.queue;

import java.util.concurrent.LinkedTransferQueue;

public class LinkedTransferQueueTest {
    public static void main(String[] args) {
        LinkedTransferQueue<String> queue = new LinkedTransferQueue<>();

        queue.add("one");
        queue.add("two");
    }
}
