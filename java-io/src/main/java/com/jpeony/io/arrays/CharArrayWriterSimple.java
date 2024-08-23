package com.jpeony.io.arrays;

import java.io.CharArrayWriter;

public class CharArrayWriterSimple {
    public static void main(String[] args) {
        try {
            // 创建字符数组输出流
            CharArrayWriter writer = new CharArrayWriter();
            // 将数据转化为字符数组
            String str = "abcdefghijklmnopqrstuvwxyz";
            char[] chars = str.toCharArray();
            // 将字符数据写入到CharArrayWriter
            writer.write(chars);
            // 将写入的数据以字符数组的形式返回
            char[] data = writer.toCharArray();
            // 打印内容
            StringBuilder sb = new StringBuilder();
            for (char c : data) {
                sb.append(c);
            }
            System.out.println("内容:" + sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}