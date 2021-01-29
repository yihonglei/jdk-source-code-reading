package com.jpeony.io.bytestream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件读取步骤：
 * 1、找到指定文件
 * 2、根据文件创建文件的输入流
 * 3、创建字节数组
 * 4、读取文件内容，放到字节数组中
 * 5、关闭输入流
 *
 * @author yihonglei
 */
public class FileReadSimple {
    public static void main(String[] args) {
        // 指定文件
        File file = new File("C:\\mycode\\hello.txt");
        // 根据文件创建文件输入流
        try (FileInputStream fis = new FileInputStream(file)) {
            // 创建字节数组
            byte[] date = new byte[1024];
            // 打印文件内容
            StringBuilder sb = new StringBuilder();
            while (fis.read(date) != -1) {
                sb.append(new String(date));
            }
            System.out.println("文件内容:" + sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
