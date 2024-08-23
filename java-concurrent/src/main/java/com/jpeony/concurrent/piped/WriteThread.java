package com.jpeony.concurrent.piped;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * 写入数据线程
 */
public class WriteThread extends Thread {
    private WriteData writeData;
    private PipedOutputStream out;

    public WriteThread(WriteData writeData, PipedOutputStream out) {
        this.writeData = writeData;
        this.out = out;
    }

    @Override
    public void run() {
        try {
            writeData.writeMethod(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
