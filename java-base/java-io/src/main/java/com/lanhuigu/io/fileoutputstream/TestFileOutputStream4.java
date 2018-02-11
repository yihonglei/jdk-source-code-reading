package com.lanhuigu.io.fileoutputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * FileOutputStream(File file, boolean append)的append设置为true，输出流内容追加到文件。
 */
public class TestFileOutputStream4 {

    public static void main(String[] args) {
        // 指定构建源文件
        File file = new File("C:\\mycode\\hello.txt");
        // 根据文件创建可以追加文件内容的文件输出流
        try (OutputStream os = new FileOutputStream(file, true)) {
            // 要写入的数据，转化为字节数组
            String str= "abcdefg";
            byte[] bytes = str.getBytes();
            // 将字节数组写入到输出流，如果多执行几次，会发现文件内容在不断追加，而不是每次文件内容都被冲刷掉
            os.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
