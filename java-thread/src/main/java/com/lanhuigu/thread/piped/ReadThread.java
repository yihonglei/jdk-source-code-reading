package com.lanhuigu.thread.piped;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * 读出数据线程
 *
 * @author yihonglei
 *  2019/2/15 17:31
 */
public class ReadThread extends Thread {
    private ReadData readData;
    private PipedInputStream input;

    public ReadThread(ReadData readData, PipedInputStream input) {
        this.readData = readData;
        this.input = input;
    }

    @Override
    public void run() {
        try {
            readData.readMethod(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
