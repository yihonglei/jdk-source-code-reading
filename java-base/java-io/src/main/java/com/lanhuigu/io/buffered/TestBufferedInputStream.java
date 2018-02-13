package com.lanhuigu.io.buffered;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestBufferedInputStream {

    public static void main(String[] args) {
        // 指定构建文件
        File file = new File("C:\\mycode\\hello.txt");
        // 根据File创建文件输入流FileInputStream，在根据FileInputStream创建BufferedInputStream对象
        try (FileInputStream is = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(is)) {
            // 文件内容
            StringBuffer sb = new StringBuffer();
            // 创建字节数组缓冲区
            byte[] buffer = new byte[10240];
            // 从BufferedInputStream缓冲区读取数据存入buffer字节数组中
            int data = bis.read(buffer);
            while (data != -1 ) {
                sb.append(new java.lang.String(buffer));
                data = bis.read(buffer);
            }
            // 输出文件内容
            System.out.println("文件内容:" + sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
