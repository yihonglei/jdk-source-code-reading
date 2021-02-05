package com.jpeony.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Server 端实例代码
 *
 * @author yihonglei
 */
public class NIOServer {
    /**
     * 通道管理器(Selector)
     */
    private static Selector selector;

    public static void main(String[] args) throws IOException {
        // 创建通道管理器(Selector)
        selector = Selector.open();

        // 创建通道ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 将通道设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 将ServerSocketChannel对应的ServerSocket绑定到指定端口(port)
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8989));

        /*
         * 将通道(Channel)注册到通道管理器(Selector)，并为该通道注册selectionKey.OP_ACCEPT事件
         * 注册该事件后，当事件到达的时候，selector.select()会返回，
         * 如果事件没有到达selector.select()会一直阻塞。
         */
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 循环处理
        while (true) {
            // 当注册事件到达时，方法返回，否则该方法会一直阻塞（查询准备就绪数据进来的通道）
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

                // 检查是否是一个就绪的可以被接受的客户端请求连接
                if (key.isAcceptable()) {
                    handleAccept(key);
                } else if (key.isReadable()) {// 检查套接字是否已经准备好读数据
                    handleRead(key);
                }
            }
        }
    }

    /**
     * 处理客户端连接成功事件
     */
    private static void handleAccept(SelectionKey key) throws IOException {
        // 获取客户端连接通道
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = server.accept();
        socketChannel.configureBlocking(false);

        // 信息通过通道发送给客户端
        String msg = "Hello Client!";
        socketChannel.write(ByteBuffer.wrap(msg.getBytes()));

        // 给通道设置读事件，客户端监听到读事件后，进行读取操作
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    /**
     * 监听到读事件，读取客户端发送过来的消息
     */
    private static void handleRead(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.channel();

        // 从通道读取数据到缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(128);
        channel.read(buffer);

        // 输出客户端发送过来的消息
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("server received msg from client：" + msg);
    }
}
