package com.jpeony.io.inputstream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 在创建BufferedInputStream时，会创建一个内部缓冲区数组，默认缓存数组大小为8k。
 * 在读取流中的字节时，可根据需要从包含的输入流再次填充该内部缓冲区，一次填充多个字节。
 * 也就是说，Buffered类初始化时会创建一个较大的byte数组，一次性从底层输入流中
 * 读取多个字节来填充byte数组，当程序读取一个或多个字节时，可直接从缓存区byte数组中获取，
 * 当内存中的byte读取完后，会再次用底层输入流填充缓冲区数组。
 *
 * @author yihonglei
 */
public class BufferedInputStreamSimple {

    public static void main(String[] args) {
        // 指定构建文件
        File file = new File("C:\\mycode\\hello.txt");
        // 根据File创建文件输入流FileInputStream，在根据FileInputStream创建BufferedInputStream对象
        try (FileInputStream is = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(is)) {
            // 文件内容
            StringBuffer sb = new StringBuffer();
            // 创建字节数组
            byte[] bArray = new byte[10240];
            // 从BufferedInputStream的缓冲区读取数据到bArray字节数组中
            int data = bis.read(bArray);
            while (data != -1) {
                sb.append(new java.lang.String(bArray));
                data = bis.read(bArray);
            }
            // 输出文件内容
            System.out.println("文件内容:" + sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
