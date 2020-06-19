package com.example.learn.internet.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 多次交流: 发送端
 * 1、使用DatagramSocket  指定端口 创建发送端
 * 2、准备数据 一定转成字节数组
 * 3、 封装成DatagramPacket 包裹，需要指定目的地
 * 4、发送包裹send​(DatagramPacket p) * 
 * 5、释放资源
 * @author 裴新 QQ:3401997271
 *
 */
public class UdpTalkClient {

	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中.....");
		 // 1、使用DatagramSocket  指定端口 创建发送端
		DatagramSocket client =new DatagramSocket(8888);
		 //2、准备数据 一定转成字节数组
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String data = reader.readLine();
			byte[] datas = data.getBytes();
			 //3、 封装成DatagramPacket 包裹，需要指定目的地
			DatagramPacket packet =new DatagramPacket(datas,0,datas.length,
					new InetSocketAddress("localhost",6666));
			//4、发送包裹send​(DatagramPacket p) * 
			client.send(packet);
			if(data.equals("bye")) {
				break;
			}
		}
		// 5、释放资源
		client.close();
	}

}
