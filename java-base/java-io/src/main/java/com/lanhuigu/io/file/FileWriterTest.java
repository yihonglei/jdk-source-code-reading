package com.lanhuigu.io.file;

import java.io.*;

/**
 * 写入文件：
 * 1、找到指定的文件
 * 2、根据文件创建文件的输出流
 * 3、把内容转换成字符数组
 * 4、向文件写入内容
 * 5、关闭输入流
 */
public class FileWriterTest {
    public static void main(String[] args) {
        // 构建指定文件
        File file = new File("C:\\mycode\\hello.txt");
        // 根据文件创建文件的输出流
        try (Writer writer = new FileWriter(file)) {
            String str = "我是中国人-FileWriter";
            // 把内容转换成字符数组
            char[] data = str.toCharArray();
            // 向文件写入内容
            writer.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
