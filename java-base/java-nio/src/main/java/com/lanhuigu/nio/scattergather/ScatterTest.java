package com.lanhuigu.nio.scattergather;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通道中的数据分散写入到多个缓冲区
 * @author yihonglei
 * @ClassName: ScatterTest
 * @Package: com.lanhuigu.nio.scattergather
 * @date 2018/5/15 9:50
 * @version 1.0.0
 */
public class ScatterTest {
    public static void main(String[] args) {
        // 指定构建文件
        File file = new File("C:\\mycode\\hello.txt");
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw");
             FileChannel channel = raf.getChannel()){

            // 分配缓冲区大小
            ByteBuffer header = ByteBuffer.allocate(48);
            ByteBuffer body = ByteBuffer.allocate(1024);

            // 缓冲区加入数组
            ByteBuffer[] bufferArray = {header, body};

            /**
             * buffer首先被插入到数组，然后再将数组作为channel.read() 的输入参数。
             * read()方法按照buffer在数组中的顺序将从channel中读取的数据写入到buffer，
             * 当一个buffer被写满后，channel紧接着向另一个buffer中写。
             */
            channel.read(bufferArray);

            // Buffer切换模式之前，即处于写模式下，打印Buffer，查看position, limit, capacity属性
            System.out.println(header.toString());
            System.out.println(body.toString());

            // Buffer切换为读模式
            header.flip();
            body.flip();

            // 分割线
            System.out.println("==============切换模式前后Buffer中position, limit ,capacity属性=================");

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
