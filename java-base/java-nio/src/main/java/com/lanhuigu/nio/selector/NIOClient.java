package com.lanhuigu.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * client实例代码
 *
 * @author yihonglei
 * @date 2018/5/15 13:48
 */
public class NIOClient {
    // 通道管理器(Selector)
    private static Selector selector;

    public static void main(String[] args) throws IOException {
        // 创建通道管理器(Selector)
        selector = Selector.open();

        // 创建通道SocketChannel
        SocketChannel channel = SocketChannel.open();
        // 将通道设置为非阻塞
        channel.configureBlocking(false);

        // 客户端连接服务器，其实方法执行并没有实现连接，需要在handleConnect方法中调channel.finishConnect()才能完成连接
        channel.connect(new InetSocketAddress("localhost", 8989));

        /**
         * 将通道(Channel)注册到通道管理器(Selector)，并为该通道注册selectionKey.OP_CONNECT
         * 注册该事件后，当事件到达的时候，selector.select()会返回，
         * 如果事件没有到达selector.select()会一直阻塞。
         */
        channel.register(selector, SelectionKey.OP_CONNECT);

        // 循环处理
        while (true) {
            /*
             * 选择一组可以进行I/O操作的事件，放在selector中，客户端的该方法不会阻塞，
             * selector的wakeup方法被调用，方法返回，而对于客户端来说，通道一直是被选中的
             * 这里和服务端的方法不一样，查看api注释可以知道，当至少一个通道被选中时。
             */
            selector.select();

            // 获取监听事件
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            // 迭代处理
            while (iterator.hasNext()) {
                // 获取事件
                SelectionKey key = iterator.next();

                // 移除事件，避免重复处理
                iterator.remove();

                // 检查是否是一个就绪的已经连接服务端成功事件
                if (key.isConnectable()) {
                    handleConnect(key);
                } else if (key.isReadable()) {// 检查套接字是否已经准备好读数据
                    handleRead(key);
                }

            }
        }
    }

    /**
     * 处理客户端连接服务端成功事件
     */
    private static void handleConnect(SelectionKey key) throws IOException {
        // 获取与服务端建立连接的通道
        SocketChannel channel = (SocketChannel) key.channel();
        if (channel.isConnectionPending()) {
            // channel.finishConnect()才能完成连接
            channel.finishConnect();
        }

        channel.configureBlocking(false);

        // 数据写入通道
        String msg = "Hello Server!";
        channel.write(ByteBuffer.wrap(msg.getBytes()));

        // 通道注册到选择器，并且这个通道只对读事件感兴趣
        channel.register(selector, SelectionKey.OP_READ);
    }

    /**
     * 监听到读事件，读取客户端发送过来的消息
     */
    private static void handleRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();

        // 从通道读取数据到缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(128);
        channel.read(buffer);

        // 输出服务端响应发送过来的消息
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("client received msg from server：" + msg);
    }
}
