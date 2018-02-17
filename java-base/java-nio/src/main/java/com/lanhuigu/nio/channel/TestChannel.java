package com.lanhuigu.nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 利用通道完成文件复制
 */
public class TestChannel {
    public static void main(String[] args) {
        try (
             // 根据指定文件创建文件输入流
             FileInputStream fis = new FileInputStream("C:\\mycode\\hello.txt");
             // 根据文件创建文件输出流，如果文件不存在，自动创建文件
             FileOutputStream fos = new FileOutputStream("C:\\mycode\\hello-copy.txt");
             // 1. 获取通道
             FileChannel inChannel = fis.getChannel(); FileChannel outChannel = fos.getChannel()) {
            // 2. 分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(48);
            // 3. 将通道中的数据读取到缓冲区中
            while (inChannel.read(buffer) != -1) {
                // 切换成数据模式
                buffer.flip();
                // 4. 将缓冲区中的数据写入到通道中
                outChannel.write(buffer);
                // 清空缓冲区
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
