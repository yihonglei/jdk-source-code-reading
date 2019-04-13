package com.lanhuigu.nio.selectors;

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
    /**
     * 通道管理器
     */
    private Selector selector;

    /**
     * 获得一个Socket通道，并对该通道做一些初始化的工作
     *
     * @param ip   连接服务器ip
     * @param port 连接服务器端口
     * @throws IOException
     */
    private void initClient(String ip, int port) throws IOException {
        // 获得一个Socket通道
        SocketChannel channel = SocketChannel.open();
        // 设置通道为非阻塞
        channel.configureBlocking(false);
        // 获得一个通道管理器
        this.selector = Selector.open();
        // 用channel.finishConnect();才能完成连接
        // 客户端连接服务器,其实方法执行并没有实现连接，需要在listen()方法中调
        channel.connect(new InetSocketAddress(ip, port));
        // 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件
        channel.register(selector, SelectionKey.OP_CONNECT);
    }

    /**
     * 采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理
     *
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    private void listen() throws Exception {
        // 轮询访问selector
        while (true) {
            /*
             * 选择一组可以进行I/O操作的事件，放在selector中,客户端的该方法不会阻塞，
             * selector的wakeup方法被调用，方法返回，而对于客户端来说，通道一直是被选中的
             * 这里和服务端的方法不一样，查看api注释可以知道，当至少一个通道被选中时。
             */
            selector.select();
            // 获得selector中选中的项的迭代器
            Set<SelectionKey> selectionKeys = this.selector.selectedKeys();
            // 获得selector中选中的相的迭代器，选中的相为注册的事件
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                // 删除已选的key，以防重复处理
                iterator.remove();
                // 连接事件发生
                if (key.isConnectable()) {
                    // 如果正在连接，则完成连接
                    SocketChannel channel = (SocketChannel) key.channel();
                    if (channel.isConnectionPending()) {
                        channel.finishConnect();
                    }
                    // 设置成非阻塞
                    channel.configureBlocking(false);
                    // 在这里可以给服务端发送信息哦
                    channel.write(ByteBuffer.wrap(new String("hello server!").getBytes()));
                    // 在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。
                    // 获得了可读的事件
                    channel.register(this.selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    read(key);
                }
            }
        }
    }

    /**
     * @param key
     * @throws Exception
     */
    private void read(SelectionKey key) throws Exception {
        SocketChannel channel = (SocketChannel) key.channel();
        // 分配缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("client receive msg from server:" + msg);
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
        channel.write(outBuffer);
    }

    /**
     * 启动客户端测试
     */
    public static void main(String[] args) throws Exception {
        NIOClient client = new NIOClient();
        client.initClient("localhost", 8989);
        client.listen();
    }
}
