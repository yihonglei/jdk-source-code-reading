package com.jpeony.thread.queue;

import java.util.LinkedList;
import java.util.List;

/**
 * 阻塞队列
 *
 * @author yihonglei
 *  2018/4/20 17:58
 */
public class BlockingQueue {
    private List queue = new LinkedList();

    private int limit = 10;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    /*************************************************************************************************************************************
     * 在enqueue和dequeue方法内部，只有队列的大小等于上限（limit）或者下限（0）时，才调用notifyAll方法。                                 *
     * 如果队列的大小既不等于上限，也不等于下限，任何线程调用enqueue或者dequeue方法时，都不会阻塞，都能够正常的往队列中添加或者移除元素。*
     * ***********************************************************************************************************************************
     */
    /**
     * 入队: 当队列满时，阻塞入队
     *
     * @param item 队列元素
     * @throws InterruptedException
     */
    public synchronized void enqueue(Object item) throws InterruptedException {
        while (this.queue.size() == this.limit) {
            wait();
        }

        if (this.queue.size() == 0) {
            notifyAll();
        }
    }

    /**
     * 出队: 当队列为空时，阻塞出队
     *
     * @return Object 队列元素
     * @throws InterruptedException
     */
    public synchronized Object dequeue() throws InterruptedException {
        while (this.queue.size() == 0) {
            wait();
        }

        if (this.queue.size() == this.limit) {
            notifyAll();
        }

        return this.queue.remove(0);
    }

}
