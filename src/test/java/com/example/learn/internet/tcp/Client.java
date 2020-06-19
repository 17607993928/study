package com.example.learn.internet.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 熟悉流程
 * 创建客户端
 * 1、建立连接: 使用Socket创建客户端 +服务的地址和端口
 * 2、操作: 输入输出流操作
 * 3、释放资源 
 * @author 裴新 QQ:3401997271
 *
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("-----Client-----");
		//1、建立连接: 使用Socket创建客户端 +服务的地址和端口
		Socket client =new Socket("localhost",8888);
		//2、操作: 输入输出流操作
		DataOutputStream dos =new DataOutputStream(client.getOutputStream());
		String data ="hello";
		dos.writeUTF(data);
		dos.flush();
		//3、释放资源 
		dos.close();
		client.close();
	}

}
