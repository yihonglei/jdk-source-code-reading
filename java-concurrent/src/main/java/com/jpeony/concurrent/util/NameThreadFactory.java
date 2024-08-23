package com.jpeony.concurrent.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程命名
 */
public class NameThreadFactory implements ThreadFactory {
    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private ThreadGroup threadGroup;
    private String namePrefix;
    private boolean daemon;
    private int priority;
    private String name;

    private NameThreadFactory(String name, boolean daemon, int priority) {
        if (priority > Thread.MAX_PRIORITY || priority < Thread.MIN_PRIORITY) {
            throw new IllegalArgumentException("priority: " + priority + " (expected: Thread.MIN_PRIORITY <= priority <= Thread.MAX_PRIORITY)");
        }

        this.name = name;
        this.daemon = daemon;
        this.priority = priority;
        SecurityManager sm = System.getSecurityManager();
        this.threadGroup = sm != null ? sm.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.namePrefix = "pool-" + POOL_NUMBER.getAndIncrement() + "-" + name;
    }

    NameThreadFactory(String name) {
        this(name, false, Thread.NORM_PRIORITY);
    }

    public NameThreadFactory(String name, boolean daemon) {
        this(name, daemon, Thread.NORM_PRIORITY);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(this.threadGroup, r, this.namePrefix + "-" + this.threadNumber.getAndIncrement(), 0);
        if (t.isDaemon()) {
            if (!this.daemon) {
                t.setDaemon(false);
            } else {
                t.setDaemon(true);
            }
        }

        if (t.getPriority() != this.priority) {
            t.setPriority(Thread.NORM_PRIORITY);
        }

        return t;
    }

    public String getName() {
        return name;
    }
}
