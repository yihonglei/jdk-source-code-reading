package com.lanhuigu.io.test;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * 写线程
 */
public class WriteThread implements Runnable{
    private PipedOutputStream output;

    public WriteThread (PipedOutputStream pipedOutputStream) {
        this.output = pipedOutputStream;
    }

    @Override
    public void run() {
        try {
            String str = "Hello-Piped!";
            byte[] data = str.getBytes();
            output.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
