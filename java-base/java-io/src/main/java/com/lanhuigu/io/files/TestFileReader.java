package com.lanhuigu.io.files;

import java.io.*;

/**
 * 读取文件：
 * 1、找到指定的文件
 * 2、根据文件创建文件的输入流
 * 3、创建字符数组
 * 4、读取内容，放到字符数组里面
 * 5、关闭输入流
 */
public class TestFileReader {
    public static void main(String[] args) {
        // 构建指定文件
        File file = new File("C:\\mycode\\hello.txt");
        // 根据文件创建文件的输入流
        try (Reader reader = new FileReader(file)) {
            // 创建字符数组
            char[] data = new char[1024];
            // 读取内容，存储到缓冲字符数组里面
            reader.read(data);
            System.out.println("文件内容:" + new String(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
