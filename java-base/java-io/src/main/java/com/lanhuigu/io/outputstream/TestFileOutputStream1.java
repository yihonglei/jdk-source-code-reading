package com.lanhuigu.io.outputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * write(int b):
 * 把单个字节写入到输出流中。
 */
public class TestFileOutputStream1 {

    public static void main(String[] args) {
        // 指定构造文件(如果指定文件不存在，会创建对应文件)
        File file = new File("C:\\mycode\\hello.txt");
        // 根据文件创建文件输出流
        try (OutputStream os = new FileOutputStream(file)) {
            // 创建要写入输出流的数据
            String str = "abcdefg";
            byte[] data = str.getBytes();
            // 通过write(int b)将数据写入到输出流，操作系统设备根据输出流处理到终端文件
            for (byte b : data) {
                os.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
