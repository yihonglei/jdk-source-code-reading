package com.lanhuigu.io;


import java.io.*;

public class Test {
    public static void main(String[] args) {
        // 找到指定文件
        File file = new File("C:\\mycode\\hello.txt");
        // 根据文件创建文件的输出流
        try (Writer writer = new FileWriter(file)) {
            String str = "我的写入内容";
            // 创建字节数组
            char[] data = new char[1024];
            // 将字节数组写入到文件中
            writer.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
