package com.lanhuigu.io.outputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 在finally语句块中关闭流，此方案虽然能关闭流，但是并不完美。
 *
 * @author yihonglei
 */
public class FileOutputStream4 {
    public static void main(String[] args) {
        // 指定构建文件
        File file = new File("C:\\mycode\\hello.txt");
        OutputStream os = null;
        try {
            // 创建文件输出流
            os = new FileOutputStream(file);
            // 创建要写入输出流的数据
            String str = "abcdefg";
            byte[] data = str.getBytes();
            // 将数据字节数组一次行写入到FileOutputStream(文件输出流)中
            os.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭输出流
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
