package com.lanhuigu.io.inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class TestFileInputStream1 {

    public static void main(String[] args) {
        // 指定构建文件
        File file = new File("C:\\mycode\\hello.txt");
        // 将文件构建为输入流
        try (InputStream is = new FileInputStream(file)) {
            StringBuilder sb = new StringBuilder();
            // 读取第一个字节
            int data = is.read();
            // 判断是否是末尾流
            while (data != -1) {
                sb.append((char)data);
                // 读取下一个字节
                data = is.read();
            }
            // 输出到控制台
            System.out.println("内容:" + sb.toString().getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
