package com.lanhuigu.io.test;


import java.io.*;

public class TestBufferedInputStream {
    public static void main(String[] args) {
        File file = new File("C:\\mycode\\hello.txt");
        try (InputStream is = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(is)) {
            // file content
            StringBuilder sb = new StringBuilder();
            // crate ByteArray
            byte[] b = new byte[1024];
            // 从BufferedInputStream缓冲区读取数据到字节数组b中
            int data = bis.read(b);
            while (data != -1) {
                sb.append(new String(b));
                data = bis.read(b);
            }
            System.out.println("文件内容:" + sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
