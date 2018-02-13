package com.lanhuigu.io.buffered;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestBufferedWriter {

    public static void main(String[] args) {
        // 指定构建文件
        File file = new File("C:\\mycode\\hello.txt");
        // 创建字符缓冲输出流
        try (FileWriter writer = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(writer)) {
            // 要写数据
            String str = "abcd";
            char[] data = str.toCharArray();
            // 写入
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
