package com.lanhuigu.io.inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestFileInputStream3 {

    public static void main(String[] args) {
        // 构建输入流
        File file = new File("C:\\mycode\\hello.txt");
        try (InputStream is = new FileInputStream(file)) {
            // 创建字节数组
            byte[] data = new byte[1024];
            // 指定索引起始位置到结束位置读取流放入字节数组中
            is.read(data, 0, data.length);
            // 打印文件内容
            System.out.println("内容:" + new String(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
