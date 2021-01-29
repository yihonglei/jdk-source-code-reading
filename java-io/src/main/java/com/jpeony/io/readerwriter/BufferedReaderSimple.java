package com.jpeony.io.readerwriter;

import java.io.*;

/**
 * @author yihonglei
 */
public class BufferedReaderSimple {

    public static void main(String[] args) {
        // 指定构建文件
        File file = new File("C:\\mycode\\hello.txt");
        // 创建字符输入流
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {
            // 自定义字符数组
            char[] data = new char[1024];
            // 读取文件
            br.read(data);
            // 输出文件内容
            System.out.println("文件内容;" + new String(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
