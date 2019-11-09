package com.lanhuigu.io.bytestream;

import java.io.*;

/**
 * 实现思路：
 * 1、构建源文件与目标文件
 * 2、源文件创建输入流，目标文件创建输出流
 * 3、创建字节数组
 * 4、使用循环，源文件读取一部分内容，目标文件写入一部分内容，直到写完所有内容
 * 5、关闭源文件输入流，目标文件输出流
 */
public class FileCopyTest {
    public static void main(String[] args) {
        // 构建源文件
        File file = new File("C:\\mycode\\hello.txt");
        // 构建目标文件
        File fileCopy = new File("C:\\mycode\\hello-copy.txt");
        InputStream in = null;
        OutputStream out = null;
        try {
            // 目标文件不存在就创建
            if (!(fileCopy.exists())) {
                fileCopy.createNewFile();
            }
            // 源文件创建输入流
            in = new FileInputStream(file);
            // 目标文件创建输出流
            out = new FileOutputStream(fileCopy, true);
            // 创建字节数组
            byte[] temp = new byte[1024];
            int length = 0;
            // 源文件读取一部分内容
            while ((length = in.read(temp)) != -1) {
                // 目标文件写入一部分内容
                out.write(temp, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭文件输入输出流
                in.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
