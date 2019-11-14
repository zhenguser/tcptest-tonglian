package com.tonglian.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class SocketTcpServer {

    public static void main(String[] args) throws IOException {
        SocketTcpServer.serverStart();

    }

    public static void serverStart() throws IOException {
        // 创建Server Socket
        ServerSocket serverSocket = new ServerSocket();
        // 创建Socket 监听连接地址和端口号
        SocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 8083);
        // 绑定监听地址
        serverSocket.bind(address);

        System.out.println("服务器已启动..");
        Socket accept = serverSocket.accept();
        // 获取OutputStream流
        PrintWriter socketOut = new PrintWriter(accept.getOutputStream());
        byte buf[] = new byte[1024];
        if (accept.getInputStream().read(buf) > 0) {
            System.out.println("服务器端接受到客户端消息：" + new String(buf));
        }
        // 服务器端响应消息
        String sendStr = "response";
        socketOut.write(sendStr);
        socketOut.flush();

        // 关闭所有连接
        socketOut.close();
        accept.close();
        serverSocket.close();
    }
}
