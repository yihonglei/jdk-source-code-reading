package com.lanhuigu.nio.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用Buffer读写数据一般遵循以下四个步骤：
 * 1）写入数据到Buffer，一般有可以从Channel中读取到缓冲区，也可以调用put方法写入。
 * 2）调用flip()方法，切换数据模式。
 * 3）从Buffer中读取数据
 * 4）调用clear()方法或者compact()方法
 * 当向buffer写入数据时，buffer会记录下写了多少数据。一旦要读取数据，需要通过flip()方法将Buffer从写模式切换到读模式。
 * 在读模式下，可以读取之前写入到buffer的所有数据。一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。
 * <p>
 * 有两种方式能清空缓冲区：
 * 1）clear()方法会清空整个缓冲区。
 * 2）compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
 *
 * @author yihonglei
 */
public class BufferRWTest {
    /**
     * 文件复制实例
     */
    public static void main(String[] args) {
        // 源文件
        File fromFile = new File("/Users/yihonglei/tmp/hello.txt");
        // 目标文件
        File toFile = new File("/Users/yihonglei/tmp/hello-copy.txt");

        try (
                // 根据源文件创建文件输入流
                FileInputStream fis = new FileInputStream(fromFile);
                // 根据目标文件创建文件输出流，如果文件不存在，自动创建
                FileOutputStream fos = new FileOutputStream(toFile);

                // 1、获取通道
                FileChannel inChannel = fis.getChannel();
                FileChannel outChannel = fos.getChannel();
        ) {
            // 2、分配指定大小的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(48);

            // 3、将通道中的数据读取到缓冲区
            while (inChannel.read(buffer) != -1) {
                // 切换成读数据模式
                buffer.flip();

                // 4、从缓冲区读取数据写入到通道中
                outChannel.write(buffer);

                // 5、清空缓冲区
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
