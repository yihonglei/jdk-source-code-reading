package com.jpeony.io.inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 读取基于字节的数据:
 * 构建文件流，从输入流中读取字节数据存储到缓冲字节数组中，然后将缓冲字节数组转换成字符串打印到控制台
 * FileInputStream是InputStream的子类，所以可以把FileInputStream赋值给InputStream。
 * 这里使用"try-with-resources"来关闭流，也即当退出try语句块的时候，InputStream流会关闭。
 */
public class FileInputStream2 {
    public static void main(String[] args) {
        // 指定构造文件
        File file = new File("C:\\mycode\\hello.txt");
        // 将文件构建为输入流
        try (InputStream is = new FileInputStream(file)) {
            // 创建字节数组
            byte[] data = new byte[1024];
            // 从文件流中读取数据，存储到缓冲字节数组
            is.read(data);
            // 输出文件内容
            System.out.println("文件内容:" + new String(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
