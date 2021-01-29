package com.jpeony.io.bytestream;

import java.io.*;

/**
 * 写入文件：
 * 1、找到指定的文件
 * 2、根据文件创建文件的输出流
 * 3、把内容转换成字节数组
 * 4、向文件写入内容
 * 5、关闭输入流
 */
public class FileWriterSimple {
    public static void main(String[] args) {
        // 构建指定文件
        File file = new File("C:\\mycode\\hello.txt");
        // 根据文件创建文件的输出流
        try (OutputStream os = new FileOutputStream(file)) {
            String str = "我是中国人";
            // 把内容转换成字节数组
            byte[] data = str.getBytes();
            // 向文件写入内容
            os.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}