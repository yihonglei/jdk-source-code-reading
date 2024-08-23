package com.jpeony.collection.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 阻塞队列
 */
public class LinkedBlockingQueueTest {
    private final static Logger logger = LoggerFactory.getLogger(LinkedBlockingQueueTest.class);

    public static void main(String[] args) throws InterruptedException {
        // 创建队列
        LinkedBlockingQueue blockingQueue = new LinkedBlockingQueue();

        // 存入元素
        // offer() 非阻塞，队列满了就放不进去，也不会等着空的时候再放，直接返回 false；
        blockingQueue.offer("object01");
        blockingQueue.offer("object02");
        blockingQueue.offer("object03");

        // put() 阻塞，当队列满了，一直等着啥时候空了，啥时候放，很执着；
        blockingQueue.put("object02");

        // take() 阻塞，当队列没有元素的时候，阻塞当前线程，直到队列不为空；
        logger.info("blockingQueue.take()={}", blockingQueue.take());
        blockingQueue.take();

        // poll 非阻塞，队列为空时，直接退出，不进行阻塞操作；
        logger.info("blockingQueue.poll()={}", blockingQueue.poll());
    }
}
