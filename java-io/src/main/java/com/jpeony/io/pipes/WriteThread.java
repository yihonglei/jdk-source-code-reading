package com.jpeony.io.pipes;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * 通过管道输出流(PipedOutputStream)向管道输入流(PipedInputStream)的缓冲区写入数据。
 */
public class WriteThread implements Runnable {
    /**
     * 管道输出流
     */
    private PipedOutputStream output;

    public WriteThread(PipedOutputStream output) {
        this.output = output;
    }

    @Override
    public void run() {
        String str = "hello, piped!";
        try {
            // 向管道输入流(PipedInputStream)的缓冲区写入数据
            output.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭管道输出流
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
