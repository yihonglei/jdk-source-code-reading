package com.jpeony.nio.scattergather;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 多个缓冲区中的数据聚合写入到通道
 *
 * @author yihonglei
 */
public class GatherTest {
    public static void main(String[] args) {
        // 指定构建文件
        File file = new File("C:\\mycode\\hello.txt");
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw");
             FileChannel channel = raf.getChannel()) {

            // 分配缓冲区大小
            ByteBuffer header = ByteBuffer.allocate(8);
            ByteBuffer body = ByteBuffer.allocate(8);

            // 写入数据到Buffer
            header.put(new byte[]{1, 2, 3, 4, 5, 6, 7, 8});
            body.put(new byte[]{9, 10, 11, 12, 13, 14, 15, 16});

            // Buffer放入数组
            ByteBuffer[] bufferArray = {header, body};

            // 切换模式之前，即处于写模式下，打印Buffer，查看position, limit, capacity属性
            System.out.println(header.toString());
            System.out.println(body.toString());

            // 分割线
            System.out.println("==============切换模式前后Buffer中position, limit ,capacity属性=================");

            // 切换为读模式
            header.flip();
            body.flip();

            // 切换模式之后打印Buffer，查看position, limit, capacity属性
            System.out.println(header.toString());
            System.out.println(body.toString());

            /**
             * 写入数据到Channel:
             * buffers数组是write()方法的入参，write()方法会按照buffer在数组中的顺序，将数据写入到channel，
             * 注意只有position和limit之间的数据才会被写入。
             */
            long bytes = channel.write(bufferArray);
            System.out.println("从Buffer读取写入到Channel的字节数:" + bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
