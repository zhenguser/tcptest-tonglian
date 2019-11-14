package com.tonglian.socket;

import javafx.scene.chart.PieChart;

import java.io.IOException;

import static com.tonglian.socket.SocketTcpServer.serverStart;

public class TcpTimeTest {

    public static void main(String[] args) throws IOException {

        long startTime=System.currentTimeMillis();   //获取开始时间

        SocketTcpClient.clientStart();
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
