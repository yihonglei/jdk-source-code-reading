package com.lanhuigu.io.arrays;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * ByteArrayInputStream读取数据步骤:
 * 1. 将数据转化为字节数组
 * 2. 将字节数组内容放入ByteArrayInputStream，转化为输入流
 * 3. 通过read方法读取数据并进行相应处理
 */
public class ByteArrayInputStreamTest {

    public static void main(String[] args) {
        try {
            // 把数据写入字节数组
            String str = "abcdefghijklmnopqrstuvwxyz";
            byte[] bytes = str.getBytes();
            // 把字节数组放入到ByteArrayInputStream，转化为输入流
            InputStream input = new ByteArrayInputStream(bytes);
            // 读取第一个字节
            int data = input.read();
            StringBuilder sb = new StringBuilder();
            while (data != -1) {
                // 将读取的字节拼成字符串
                sb.append((char) data);
                // 读取下一个字节
                data = input.read();
            }
            System.out.println("内容:" + sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
