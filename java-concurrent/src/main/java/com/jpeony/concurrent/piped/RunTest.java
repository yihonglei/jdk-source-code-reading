package com.jpeony.concurrent.piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 测试类
 */
public class RunTest {
    public static void main(String[] args) {
        try {
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();

            PipedInputStream inputStream = new PipedInputStream();
            PipedOutputStream outputStream = new PipedOutputStream();

            /*
             * 通过 inputStream.connect(outputStream)
             * 或
             * outputStream.connect(inputStream)
             * 使得两个Stream之间产生通信链接，进行数据交换输出与输入。
             */
            // inputStream.connect(outputStream);
            outputStream.connect(inputStream);

            ReadThread readThread = new ReadThread(readData, inputStream);
            readThread.start();

            // 休眠1秒
            Thread.sleep(1000);

            WriteThread writeThread = new WriteThread(writeData, outputStream);
            writeThread.start();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
