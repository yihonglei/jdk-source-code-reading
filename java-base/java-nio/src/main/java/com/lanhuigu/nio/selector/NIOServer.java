package com.lanhuigu.nio.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * server端实例代码
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: NIOServer
 * @Package: com.lanhuigu.nio.selector
 * @date 2018/5/15 13:48
 */
public class NIOServer {
    /** 通道管理器 */
    private Selector selector;

    /**
     * initServer方法中:
     * 1.创建Selector
     * 2.Channel注册到Selector
     * @param port
     * @throws Exception
     */
    public void initServer(int port) throws Exception {
        // 获取一个ServerSocket通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        // 设置通道为非阻塞
        serverChannel.configureBlocking(false);
        // 将该通道对于的serverSocket绑定到port端口
        serverChannel.socket().bind(new InetSocketAddress(port));
        // 获得一个通道管理器(选择器)
        this.selector = Selector.open();
        /**
         * 将通道管理器和该通道绑定，并为该通道注册selectionKey.OP_ACCEPT事件
         * 注册该事件后，当事件到达的时候，selector.select()会返回，
         * 如果事件没有到达selector.select()会一直阻塞
         */
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
    }
    /**
     * 采用轮询的方式监听selector上是否有需要处理的事件，如果有，进行处理
     * @throws Exception
     */
    public void listen() throws Exception {
        System.out.println("start server");
        // 轮询访问selector
        while (true) {
            // 当注册事件到达时，方法返回，否则该方法会一直阻塞
            selector.select();
            // 获得selector中选中的相的迭代器，选中的相为注册的事件
            Iterator ite = this.selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();
                // 删除已选的key以防重负处理
                ite.remove();
                // 客户端请求连接事件
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    // 获得和客户端连接的通道
                    SocketChannel channel = server.accept();
                    // 设置成非阻塞
                    channel.configureBlocking(false);
                    // 在这里可以发送消息给客户端
                    channel.write(ByteBuffer.wrap(new String("hello client").getBytes()));
                    // 在客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限
                    channel.register(this.selector, SelectionKey.OP_READ);
                    // 获得了可读的事件
                } else if (key.isReadable()) {
                    read(key);
                }
            }
        }
    }

    /**
     * 处理读取客户端发来的信息事件
     * @param key
     * @throws Exception
     */
    private void read(SelectionKey key) throws Exception {
        // 服务器可读消息，得到事件发生的socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        // 读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("server receive from client: " + msg);
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
        channel.write(outBuffer);
    }

    /**
     * 启动服务端测试
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args) throws Throwable {
        NIOServer server = new NIOServer();
        server.initServer(8989);
        server.listen();
    }
}
