package com.jpeony.io.outputstream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * FileOutputStream(File file, boolean append)的append设置为false，覆盖掉文件。
 * 如果为false，与FileOutputStream(File)构造器一致。
 */
public class FileOutputStream5 {

    public static void main(String[] args) {
        // 指定构建源文件
        File file = new File("C:\\mycode\\hello.txt");
        // 根据文件创建不可以追加文件内容的文件输出流
        try (OutputStream os = new FileOutputStream(file, false)) {
            // 要写入的数据，转化为字节数组
            String str = "abcdefg";
            byte[] bytes = str.getBytes();
            // 将字节数组写入到输出流，如果多执行几次，会发现文件内容并没有改变，每次都被覆盖掉了
            os.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
