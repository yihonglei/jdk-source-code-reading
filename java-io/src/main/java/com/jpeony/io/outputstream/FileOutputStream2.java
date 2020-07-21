package com.jpeony.io.outputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * write(byte b[])：将字节数组中全部数据写入到输出流中。
 *
 * @author yihonglei
 */
public class FileOutputStream2 {
    public static void main(String[] args) {
        // 指定构造文件(如果指定文件不存在，会创建对应文件)
        File file = new File("C:\\mycode\\hello.txt");
        // 根据文件创建文件输出流
        try (OutputStream os = new FileOutputStream(file)) {
            // 创建要写入输出流的数据
            String str = "abcdefg";
            byte[] data = str.getBytes();
            // 将数据字节数组一次行写入到FileOutputStream(文件输出流)中
            os.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
