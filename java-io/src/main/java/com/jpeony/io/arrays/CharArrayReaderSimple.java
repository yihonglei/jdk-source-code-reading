package com.jpeony.io.arrays;

import java.io.CharArrayReader;
import java.io.Reader;

/**
 * @author yihonglei
 */
public class CharArrayReaderSimple {

    public static void main(String[] args) {
        try {
            // 把数据写入字符数组
            String str = "abcdefghijklmnopqrstuvwxyz";
            char[] chars = str.toCharArray();
            // 把字符数组写入到CharArrayReader
            Reader reader = new CharArrayReader(chars);
            // 读取第一个字符
            int data = reader.read();
            StringBuilder sb = new StringBuilder();
            while (data != -1) {
                // 将读取的字符拼成字符串
                sb.append((char) data);
                // 读取下一个字符
                data = reader.read();
            }
            System.out.println("内容:" + sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}