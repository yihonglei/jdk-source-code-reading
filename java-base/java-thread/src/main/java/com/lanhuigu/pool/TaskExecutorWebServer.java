package com.lanhuigu.pool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutorWebServer {
    private static final int NTHREADS = 100;
    private static final ExecutorService exec =
            Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    // handleRequest(connection);
                }
            };
            /** 提交任务 */
            exec.execute(task);
        }
    }
}
