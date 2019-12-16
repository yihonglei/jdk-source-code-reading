package com.lanhuigu.io.outputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * write(byte b[], int off, int len): 把字节数据中从offset位置开始，length个字节的数据写入到输出流。
 *
 * @author yihonglei
 */
public class FileOutputStream3 {
    public static void main(String[] args) {
        // 指定构造文件(如果指定文件不存在，会创建对应文件)
        File file = new File("C:\\mycode\\hello.txt");
        // 根据文件创建文件输出流
        try (OutputStream os = new FileOutputStream(file)) {
            // 创建要写入输出流的数据
            String str = "abcdefg";
            byte[] data = str.getBytes();
            // 从offset位置开始，length个字节的数据写入到输出流
            os.write(data, 1, data.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
