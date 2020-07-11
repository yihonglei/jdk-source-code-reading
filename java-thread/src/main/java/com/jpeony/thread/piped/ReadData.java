package com.jpeony.thread.piped;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * 读出数据
 *
 * @author yihonglei
 *  2019/2/15 17:22
 */
public class ReadData {
    public void readMethod(PipedInputStream input) throws IOException {
        try {
            byte[] byteArray = new byte[20];
            int readLength = input.read(byteArray);
            while (readLength != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.println("读出数据:" + newData);
                readLength = input.read(byteArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            input.close();
        }
    }
}
