package com.example.learn.internet.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 文件存储: 接收端
 * Address already in use: Cannot bind  同一个协议下端口不允许冲突
 * 1、使用DatagramSocket  指定端口 创建接收端
 * 2、准备容器 封装成DatagramPacket 包裹
 * 3、阻塞式接收包裹receive​(DatagramPacket p)
 * 4、分析数据    将字节数组还原为对应的类型
 *    byte[]  getData​()
 *                getLength​()
 * 5、释放资源
 * @author 裴新 QQ:3401997271
 *
 */
public class UdpFileServer {

	public static void main(String[] args) throws Exception {
		System.out.println("接收方启动中.....");
		// 1、使用DatagramSocket  指定端口 创建接收端
		DatagramSocket server =new DatagramSocket(6666);
		// 2、准备容器 封装成DatagramPacket 包裹
		byte[] container =new byte[1024*60];
		DatagramPacket packet = new DatagramPacket(container,0,container.length);
		// 3、阻塞式接收包裹receive​(DatagramPacket p)
		server.receive(packet); //阻塞式
		// 4、分析数据    将字节数组还原为对应的类型
		//    byte[]  getData​()
		//                getLength​()
		 byte[]  datas =packet.getData();
		 int len = packet.getLength();		 
		 IOUtils.byteArrayToFile(datas, "src/copy.png");		 
		// 5、释放资源
		 server.close();
	}

}
