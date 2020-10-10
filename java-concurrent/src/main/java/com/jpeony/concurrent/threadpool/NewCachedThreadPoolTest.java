package com.jpeony.concurrent.threadpool;

import com.jpeony.concurrent.util.SleepUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1）核心线程数设置为0，最大线程数设置为int最大值，允许创建出操作系统允许的线程数；
 * <p>
 * 2）keepAliveTime设置为60s，控制非核心线程的退出；
 * <p>
 * 3）阻塞队列用SynchronousQueue，这个队列是BlockingQueue的一个实现，特性就是只放一个元素；
 * <p>
 * 根据ThreadPoolExecutor的execute执行任务逻辑源码，可以知道，当提交第一个任务时，入队并创建一个线程执行队列的任务，
 * <p>
 * 当不断提交任务时，队列满了的话，并且已经有线程在忙活任务的时候，直接不断创建线程执行任务，当没有任务的时候，
 * <p>
 * 线程池里的所有线程都会退出。
 *
 * @author yihonglei
 */
public class NewCachedThreadPoolTest {
    private final static Logger logger = LoggerFactory.getLogger(NewCachedThreadPoolTest.class);
    // 线程池
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int finalSeqNum = i + 1;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    logger.info("ThreadName={}, seqNum={}", Thread.currentThread().getName(), finalSeqNum);
                }
            };
            executorService.execute(runnable);
            SleepUtils.second(20);
        }
    }
}
