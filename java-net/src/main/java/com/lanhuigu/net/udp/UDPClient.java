package com.lanhuigu.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * DatagramSocket 和 DatagramPacket 两个类是 基于UDP 协议进行通信的包装类
 * 实现两个客户端通过 UDP协议通信，使用DatagramSocket 和 DatagramPacket类
 * 有如下几个步骤，分为客户端和服务端
 * <p>
 * 1、客户端
 * <p>
 * 1）实例化DatagramSocket类(带上指定端口)，创建客户端
 * <p>
 * 2）准备数据，数据是以字节数组发送的
 * <p>
 * 3）打包数据，使用 DatagramPacket 类 + 服务器地址+ 端口
 * <p>
 * 4）发送数据
 * <p>
 * 5）关闭连接
 *
 * @author yihonglei
 * @date 2019/11/5 4:13 PM
 */
public class UDPClient {
    public static void main(String[] args) throws Exception {
        // 1、创建服务端+端口
        DatagramSocket client = new DatagramSocket();
        // 2、准备数据
        String msg = "I love you!";
        byte[] data = msg.getBytes();
        // 3、打包（发送的地点及端口）
        DatagramPacket packet = new DatagramPacket(data, data.length, new InetSocketAddress("127.0.0.1", 1219));
        // 4、资源发送
        client.send(packet);
        // 5、关闭资源
        client.close();
    }
}
