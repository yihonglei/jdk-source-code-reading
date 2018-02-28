package com.lanhuigu.io.test;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * 读线程
 */
public class ReaderThread implements Runnable{
    private PipedInputStream input;

    public ReaderThread(PipedInputStream pipedInputStream) {
        this.input = pipedInputStream;
    }

    @Override
    public void run() {
        try {
            byte[] data = new byte[1024];
            input.read(data);
            System.out.println("线程传递内容:" + new String(data));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
