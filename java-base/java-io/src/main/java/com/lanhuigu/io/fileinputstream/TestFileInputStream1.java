package com.lanhuigu.io.fileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * read()
 */
public class TestFileInputStream1 {

    public static void main(String[] args) {
        // 指定构建文件
        File file = new File("C:\\mycode\\hello.txt");
        // 根据文件创建文件输入流
        try (InputStream is = new FileInputStream(file)) {
            // 用于封装字符串的StringBuilder
            StringBuilder sb = new StringBuilder();
            // 从文件输出流中读取第一个字节
            int data = is.read();
            while (data != -1) {
                sb.append((char)data);
                // 读取下一个字节
                data = is.read();
            }
            // 打印文件内容
            System.out.println("文件内容:" + sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
