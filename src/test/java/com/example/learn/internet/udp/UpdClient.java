package com.example.learn.internet.udp;

import java.io.IOException;
import java.net.*;

/**
 * @类描述:服务端  封装字节数组  封装包裹，发送
 * @创建人:xiejs
 * @创建时间:
 */
public class UpdClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中......");
        DatagramSocket datagramSocket=new DatagramSocket(8888);
        String msg="我是你爸爸";
        byte[] bytes = msg.getBytes();

        DatagramPacket datagramPacket=new DatagramPacket(bytes,0,bytes.length,new InetSocketAddress("localhost",9999));
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
