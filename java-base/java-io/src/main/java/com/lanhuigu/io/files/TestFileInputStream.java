package com.lanhuigu.io.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 读取文件：
 * 1、找到指定的文件
 * 2、根据文件创建文件的输入流
 * 3、创建字节数组
 * 4、读取内容，放到字节数组里面
 * 5、关闭输入流
 */
public class TestFileInputStream {
    public static void main(String[] args) {
        // 构建指定文件
        File file = new File("C:\\mycode\\hello.txt");
        // 根据文件创建文件的输入流
        try (InputStream is = new FileInputStream(file)) {
            // 创建字节数组
            byte[] data = new byte[1024];
            // 读取内容，放到字节数组里面
            is.read(data);
            // 将字节数组转化为字符串输出到控制台
            System.out.println("文件内容:" + new String(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
