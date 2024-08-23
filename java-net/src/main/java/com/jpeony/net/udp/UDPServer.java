package com.jpeony.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 2，服务端
 * <p>
 * 1）实例化DatagramSocket类+指定端口
 * <p>
 * 2）准备接收的字节数组，封装 DatagramPacket
 * <p>
 * 3）接受数据
 * <p>
 * 4）解析数据
 * <p>
 * 5）关闭连接

 */
public class UDPServer {
    public static void main(String[] args) throws Exception {
        // 1、创建服务端+端口
        DatagramSocket server = new DatagramSocket(1219);

        // 2、准备接收容器
        byte[] container = new byte[1024];

        // 3、封装成包 new DatagramPacket(byte[] b,int length)
        DatagramPacket packet = new DatagramPacket(container, container.length);

        // 4、接收数据,使用 DatagramSocket的实例的 receive( DatagramPacket ) 方法进行接收
        server.receive(packet);

        // 5、分析数据
        byte[] data = packet.getData();
        int length = packet.getLength();
        String msg = new String(data, 0, length);
        System.out.println(msg);
    }
}
