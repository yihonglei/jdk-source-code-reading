package com.jpeony.nio.pipe;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author yihonglei
 */
public class PipeTest {
    public static void main(String[] args) throws IOException {
        // 1. 获取管道
        Pipe pipe = Pipe.open();

        // 2. 将缓冲区数据写入到管道
        // 2.1 获取一个通道
        Pipe.SinkChannel sinkChannel = pipe.sink();
        // 2.2 定义缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(48);
        buffer.put("发送数据".getBytes());
        buffer.flip(); // 切换数据模式
        // 2.3 将数据写入到管道
        sinkChannel.write(buffer);

        // 3. 从管道读取数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        buffer.flip();
        int len = sourceChannel.read(buffer);
        System.out.println(new String(buffer.array(), 0, len));

        // 4. 关闭管道
        sinkChannel.close();
        sourceChannel.close();
    }
}

