package com.lanhuigu.io.buffered;

import java.io.*;

/**
 * 基于Buffered进行文件复制:
 * 从源文件读取--》写入到目标文件
 */
public class TestBufferedBasicCopy {
    public static void main(String[] args) {
        // 源文件
        File oldFile = new File("C:\\mycode\\hello.txt");
        // 目标文件
        File newFile = new File("C:\\mycode\\hello-copy.txt");

        try (InputStream is = new FileInputStream(oldFile);
             OutputStream os = new FileOutputStream(newFile);
             BufferedInputStream bis = new BufferedInputStream(is);
             BufferedOutputStream bos = new BufferedOutputStream(os)) {
            /** 从源文件读取数据: 代表一次最多读取1KB的内容 */
            byte[] readData = new byte[1024];
            /** 代表实际读取的字节数，如果返回-1，说明已经读完了 */
            int length = 0;
            while ((length = bis.read(readData)) != -1) {
                /** 将数据写入目标文件：length 代表实际读取的字节数 */
                bos.write(readData, 0, length);
            }
            /** 缓冲区的内容写入到文件 */
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
