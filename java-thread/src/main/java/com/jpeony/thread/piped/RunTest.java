package com.jpeony.thread.piped;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 测试类
 *
 * @author yihonglei
 *  2019/2/15 17:32
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
            //inputStream.connect(outputStream);
            outputStream.connect(inputStream);

            ReadThread readThread = new ReadThread(readData, inputStream);
            readThread.start();

            Thread.sleep(1000);// 休眠1秒

            WriteThread writeThread = new WriteThread(writeData, outputStream);
            writeThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
