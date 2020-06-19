package com.example.learn.internet.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

/**
 *  引用类型: 发送端
 * 1、使用DatagramSocket  指定端口 创建发送端
 * 2、将基本类型  转成字节数组
 * 3、 封装成DatagramPacket 包裹，需要指定目的地
 * 4、发送包裹send​(DatagramPacket p) * 
 * 5、释放资源
 * @author 裴新 QQ:3401997271
 *
 */
public class UdpObjClient {

	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中.....");
		 // 1、使用DatagramSocket  指定端口 创建发送端
		DatagramSocket client =new DatagramSocket(8888);
		 //2、准备数据 一定转成字节数组
		//写出
		ByteArrayOutputStream baos =new ByteArrayOutputStream();
		ObjectOutputStream oos =new ObjectOutputStream(new BufferedOutputStream(baos));
		//操作数据类型 +数据
		oos.writeUTF("编码辛酸泪");
		oos.writeInt(18);
		oos.writeBoolean(false);
		oos.writeChar('a');
		//对象
		oos.writeObject("谁解其中味");
		oos.writeObject(new Date());
		Employee emp =new Employee("马云",400);
		oos.writeObject(emp);
		oos.flush();
		byte[] datas =baos.toByteArray();	
		
		 //3、 封装成DatagramPacket 包裹，需要指定目的地
		DatagramPacket packet =new DatagramPacket(datas,0,datas.length,
				new InetSocketAddress("localhost",6666));
		//4、发送包裹send​(DatagramPacket p) * 
		client.send(packet);
		// 5、释放资源
		client.close();
	}

}
