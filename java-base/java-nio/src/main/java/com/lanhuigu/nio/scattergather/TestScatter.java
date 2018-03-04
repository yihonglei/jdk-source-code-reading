package com.lanhuigu.nio.scattergather;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestScatter {
    public static void main(String[] args) {
        // 指定构建文件
        File file = new File("C:\\mycode\\hello.txt");
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw");
             FileChannel channel = raf.getChannel()){

            // 分配缓冲区大小
            ByteBuffer header = ByteBuffer.allocate(8);
            ByteBuffer body = ByteBuffer.allocate(8);

            // 写入数据到Buffer
            header.put(new byte[]{1,2,3,4,5,6,7,8});
            body.put(new byte[]{9,10,11,12,13,14,15,16});
            ByteBuffer[] bufferArray = {header, body};
            channel.read(bufferArray);

            // 切换模式之前，打印Buffer，查看position, limit, capacity属性
            System.out.println(header.toString());
            System.out.println(body.toString());

            System.out.println("=============Buffer中position, limit, capacity属性=================");
            // 切换为读模式
            header.flip();
            body.flip();

            // 切换模式之后打印Buffer，查看position, limit, capacity属性
            System.out.println(header.toString());
            System.out.println(body.toString());

            // 写入数据到Channel
            long bytes = channel.write(bufferArray);
            System.out.println("从Buffer读取写入到Channel的字节数:" + bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
