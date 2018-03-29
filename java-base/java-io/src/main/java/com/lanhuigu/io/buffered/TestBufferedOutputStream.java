package com.lanhuigu.io.buffered;

import java.io.*;

public class TestBufferedOutputStream {

    public static void main(String[] args) {
        // 指定构建文件
        File file = new File("C:\\mycode\\hello.txt");
        /**
         * 创建缓冲输出流，new FileOutputStream(File fileclass, String mode),
         * mode为true，写入追加到文件，否则，不追加.
         */
        try (FileOutputStream os = new FileOutputStream(file, true);
             BufferedOutputStream bos = new BufferedOutputStream(os)) {
            // 要写入的数据
            String str = "test-BufferedOutputStream";
            byte[] data = str.getBytes();
            // 写入到缓冲输出流
            bos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
