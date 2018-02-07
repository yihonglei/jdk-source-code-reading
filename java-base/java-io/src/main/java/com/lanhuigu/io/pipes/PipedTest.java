package com.lanhuigu.io.pipes;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道流测试类，通过WriteThread线程写入数据，ReadThread线程读取数据并打印到控制台。
 */
public class PipedTest {

    public static void main(String[] args) {
        try {
            /** 管道输出流和输入流定义 */
            PipedOutputStream output = new PipedOutputStream();
            PipedInputStream input = new PipedInputStream();

            /** 写线程和读线程创建 */
            WriteThread writeThread = new WriteThread(output);
            ReadThread readThread = new ReadThread(input);

            Thread tWrite = new Thread(writeThread);
            Thread tRead = new Thread(readThread);

            /** 管道输入流和输出流通过connect方法建立关联关系 */
            output.connect(input);

            /** 通过start启动线程 */
            tWrite.start();
            tRead.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
