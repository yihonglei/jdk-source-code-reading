package com.jpeony.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * java net
 *
 * @author yihonglei
 */
public class ServerSocketTest {
    private static int portNumber = 8889;

    public static void main(String[] args) throws IOException {
        // 创建一个新的ServerSocket，用以监听指定端口上的连接请求
        ServerSocket serverSocket = new ServerSocket(portNumber);

        // 对accept()方法的调用将被阻塞，直到一个连接建立
        Socket clientSocket = serverSocket.accept();

        // 基于流的读写
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String request, response;
        // 处理循环
        while (in.readLine() != null) {
            request = in.readLine();

            // 如果客户端发送Done，则退出循环
            if ("Done".equals(request)) {
                break;
            }

            // 将请求传给服务器的处理方法
            response = processRequest(request);

            // 服务器的响应返回给客户端
            out.print(response);
        }
    }

    private static String processRequest(String request) {
        // do anything

        return "ok";
    }
}
