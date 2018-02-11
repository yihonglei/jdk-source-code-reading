package com.lanhuigu.io.fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * read(byte[] b)
 */
public class TestFileInputStream2 {

    public static void main(String[] args) {
        // 指定构建文件
        File file = new File("C:\\mycode\\hello.txt");
        // 根据文件创建文件输入流
        try (InputStream is = new FileInputStream(file)) {
            // 创建缓冲字节数组，用于存储从文件输出流读取的内容
            byte[] data = new byte[1024];
            // 从文件输入流中读取数据存储到缓冲字节数组中
            is.read(data);
            // 打印文件内容
            System.out.println("文件内容:" + new String(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
