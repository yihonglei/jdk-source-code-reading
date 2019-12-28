package com.lanhuigu.nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件随机读取
 *
 * @author yihonglei
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        try (
                // 根据指定文件创建文件输入流
                RandomAccessFile raf = new RandomAccessFile("C:\\mycode\\hello.txt", "rw");
                // 通道
                FileChannel inChannel = raf.getChannel()
        ) {
            // 分配Buffer
            ByteBuffer buffer = ByteBuffer.allocate(48);

            // 从通道读取内容，写入到缓冲区
            while (inChannel.read(buffer) != -1) {
                // 切换Buffer为读模式
                buffer.flip();

                // 判断是否有可读取内容
                while (buffer.hasRemaining()) {

                    // 通过get()从缓冲区读取数据
                    System.out.println((char) buffer.get());
                }

                // 清空缓冲区
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
