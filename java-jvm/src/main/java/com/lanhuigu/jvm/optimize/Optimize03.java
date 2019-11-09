package com.lanhuigu.jvm.optimize;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 【及时关闭流】
 * Java编程过程中，进行数据库连接、I/O流操作时务必小心，在使用完毕后，及时关闭以释放资源。
 * 因为对这些大对象的操作会造成系统大的开销，稍有不慎，将会导致严重的后果。
 */
public class Optimize03 {
    public static void main(String[] args) {
        // 指定构建文件
        File file = new File("/u01/jvm/log-my.txt");
        // 根据文件创建文件输入流
        try (InputStream is = new FileInputStream(file)) {
            // 用于封装字符串的StringBuilder
            StringBuilder sb = new StringBuilder();
            // 从文件输出流中读取第一个字节
            int data = is.read();
            while (data != -1) {
                sb.append((char) data);
                // 读取下一个字节
                data = is.read();
            }
            // 打印文件内容
            System.out.println("文件内容:" + sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
