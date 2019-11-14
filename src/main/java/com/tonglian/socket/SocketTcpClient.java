package com.tonglian.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketTcpClient {

    public static void main(String[] args) throws IOException {
        SocketTcpClient.clientStart();

    }

   public static void clientStart() throws IOException {
       // 创建socket
       final Socket socket = new Socket();
       // 创建socket地址
       SocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 8083);
       socket.connect(address);
       // 创建PrintWriter
       PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
       BufferedReader socketIn = new BufferedReader(
               new InputStreamReader(socket.getInputStream()));

       // 向服务器发送的内容
       String sendStr = "客户端：request";
       socketOut.write(sendStr);
       socketOut.flush();
       // 等待服务器端响应
       String receiveStr = socketIn.readLine();
       System.out.println("服务器端：: " + receiveStr);

       // 关闭连接
       socketOut.close();
       socketIn.close();
       socket.close();
   }
}
