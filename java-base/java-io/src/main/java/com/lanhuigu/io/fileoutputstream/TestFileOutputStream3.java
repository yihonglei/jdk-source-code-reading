package com.lanhuigu.io.fileoutputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * write(byte[] b, int off, int len): 将字节数组从off位置开始len长度字节数组数据写入到输出流
 */
public class TestFileOutputStream3 {

    public static void main(String[] args) {
        // 指定构建源文件
        File file = new File("C:\\mycode\\hello.txt");
        // 根据文件创建待写入的文件输入流
        try (OutputStream os = new FileOutputStream(file)) {
            // 要写入的数据，转化为字节数组
            String str= "abcdefg";
            byte[] bytes = str.getBytes();
            // 将字节数组写入到输出流
            os.write(bytes, 0, bytes.length-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
