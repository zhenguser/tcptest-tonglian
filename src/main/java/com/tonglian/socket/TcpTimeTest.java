package com.tonglian.socket;

import javafx.scene.chart.PieChart;

import java.io.IOException;

import static com.tonglian.socket.SocketTcpServer.serverStart;

public class TcpTimeTest {

    public static void main(String[] args) throws IOException {

        long startTime=System.currentTimeMillis();   //获取开始时间

        new Thread() {
            @Override
            public void run() {
                this.setName("t1");
                try {
                    SocketTcpServer.serverStart();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                this.setName("t2");
                try {
                    SocketTcpClient.clientStart();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
