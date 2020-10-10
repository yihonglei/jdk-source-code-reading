package com.jpeony.concurrent.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yihonglei
 */
public class LinkedBlockingQueueTest {
    private final static Logger logger = LoggerFactory.getLogger(LinkedBlockingQueueTest.class);

    public static void main(String[] args) throws InterruptedException {
        // 创建队列
        LinkedBlockingQueue blockingQueue = new LinkedBlockingQueue(10);
        // 存入元素
        // offer 非阻塞
         blockingQueue.offer("object01");
        // put 阻塞
        // blockingQueue.put("object01");
        // 循环取元素
        while (true) {
            logger.info("开始取值...");
            // take 阻塞
            // 当队列没有元素的时候，队里阻塞当前线程，直到队列不为空
            logger.info("blockingQueue.take()={}", blockingQueue.take());

            // poll 非阻塞
//            Object obj = blockingQueue.poll();
//            if (obj == null) {
//                break;
//            }
//            System.out.println(obj);
            logger.info("取值完成！");
        }
    }
}
