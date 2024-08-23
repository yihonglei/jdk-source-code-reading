package com.jpeony.concurrent.piped;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * 写入数据
 */
public class WriteData {
    public void writeMethod(PipedOutputStream out) throws IOException {
        try {
            String outData = "I love you";
            out.write(outData.getBytes());
            System.out.println("写入数据:" + outData);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭输出流
            out.close();
        }
    }
}
