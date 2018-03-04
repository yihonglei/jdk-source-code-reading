package com.lanhuigu.nio.scattergather;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestGather {
    public static void main(String[] args) {
        // 指定构建文件
        File file = new File("C:\\mycode\\hello.txt");
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw");
             FileChannel channel = raf.getChannel()){
            // 分配缓冲区大小
            ByteBuffer header = ByteBuffer.allocate(48);
            ByteBuffer body = ByteBuffer.allocate(1024);

            ByteBuffer[] bufferArray = {header, body};
            channel.read(bufferArray);

            // 切换模式之前，打印Buffer，查看position, limit, capacity属性
            System.out.println(header.toString());
            System.out.println(body.toString());

            // 切换为读模式
            header.flip();
            body.flip();

            // 切换模式之后，打印Buffer，查看position, limit, capacity属性
            System.out.println(header.toString());
            System.out.println(body.toString());

            // 打印缓冲区数据
            while (header.hasRemaining()) {
                System.out.print((char)header.get());
            }
            System.out.println("\n=============================");
            while (body.hasRemaining()) {
                System.out.print((char)body.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
