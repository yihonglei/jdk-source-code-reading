package com.lanhuigu.thread.piped;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * 写入数据线程
 *
 * @author yihonglei
 *  2019/2/15 17:25
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
