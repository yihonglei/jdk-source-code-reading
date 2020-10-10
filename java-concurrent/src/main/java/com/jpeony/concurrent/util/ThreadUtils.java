package com.jpeony.concurrent.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * 线程工具
 *
 * @author yihonglei
 */
public class ThreadUtils {
    private static final Logger logger = LoggerFactory.getLogger(ThreadUtils.class);
    private static volatile ThreadPoolExecutor executor = null;
    private static volatile StandardThreadExecutor standardExecutor = null;
    private static final int CORE_SIZE = Runtime.getRuntime().availableProcessors();
    private static final int MAX_SIZE = 3 * CORE_SIZE;
    private static final int LARGEST_SIZE = 100;
    private static final int QUEUE_SIZE = 20000;
    private static final int KEEP_ALIVE_TIME = 60;

    static {
        try {
            // CPU密集型
            int maxSize = getMaxThreadSize();
            executor = new ThreadPoolExecutor(CORE_SIZE, maxSize, KEEP_ALIVE_TIME, TimeUnit.SECONDS, new LinkedBlockingQueue<>(QUEUE_SIZE), new NameThreadFactory("common"));
            executor.allowCoreThreadTimeOut(true);
            Runtime.getRuntime().addShutdownHook(new Thread(ThreadUtils::shutDown));
            // IO密集型
            standardExecutor = new StandardThreadExecutor(2 * CORE_SIZE, maxSize, KEEP_ALIVE_TIME, TimeUnit.SECONDS, QUEUE_SIZE, new NameThreadFactory("standard-common"));
            standardExecutor.allowCoreThreadTimeOut(true);
            Runtime.getRuntime().addShutdownHook(new Thread(ThreadUtils::shutDownStand));
        } catch (Exception e) {
            logger.error("初始化线程池异常");
        }
    }

    /**
     * CPU密集,无返回值
     *
     * @param task 业务线程
     */
    public static void execute(Runnable task) {
        executor.execute(task);
    }

    /**
     * CPU密集,有返回值
     *
     * @param task 业务线程
     */
    public static <V> Future<V> submit(Callable<V> task) {
        return executor.submit(task);
    }

    /**
     * CPU密集,有返回值
     *
     * @param task 业务线程
     */
    public static <V> Future<V> submit(Runnable task, V v) {
        return executor.submit(task, v);
    }

    /**
     * IO密集,有无返回值
     *
     * @param task 业务线程
     */
    public static void executeStandard(Runnable task) {
        standardExecutor.execute(task);
    }

    /**
     * IO密集,有返回值
     *
     * @param task 业务线程
     */
    public static <V> Future<V> submitStandard(Callable<V> task) {
        return executor.submit(task);
    }

    /**
     * IO密集,有返回值
     *
     * @param task 业务线程
     */
    public static <V> Future<V> submitStandard(Runnable task, V v) {
        return executor.submit(task, v);
    }

    private static void shutDown() {
        logger.info("关闭executor线程池...");
        if (executor != null) {
            executor.shutdown();
            executor = null;
        }
    }

    private static void shutDownStand() {
        logger.info("关闭standardExecutor线程池...");
        if (standardExecutor != null) {
            standardExecutor.shutdown();
            standardExecutor = null;
        }
    }

    /**
     * 最大线程数
     */
    private static int getMaxThreadSize() {
        int maxSize = MAX_SIZE;
        if (maxSize > LARGEST_SIZE) {
            maxSize = LARGEST_SIZE;
        }
        return maxSize;
    }
}
