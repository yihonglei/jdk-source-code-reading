package com.lanhuigu.thread.threadpool.dbpool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: ConnectionPool
 * @Package: com.lanhuigu.thread.threadpool.dbpool
 * @date 2018/7/24 9:34
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }
}
