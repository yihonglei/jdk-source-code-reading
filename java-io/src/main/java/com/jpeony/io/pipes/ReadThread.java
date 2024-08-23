package com.jpeony.io.pipes;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * 通过管道输入流(PipedInputStream)从管道输出流(PipedInputStream)的缓存区读取数据。
 */
public class ReadThread implements Runnable {
    /**
     * 管道输入流
     */
    private PipedInputStream input;

    public ReadThread(PipedInputStream input) {
        this.input = input;
    }

    @Override
    public void run() {
        try {
            // 创建字节数组
            byte[] data = new byte[1024];
            // 将管道输出流内容放入字节数组中
            input.read(data);
            // 字节数组转换为字符串
            String str = new String(data);
            // 打印读取到的管道流内容
            System.out.println("读取到的管道流内容: " + str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭管道输入流
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}