package com.example.learn.internet.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 存储文件
 * 创建服务器
 * 1、指定端口 使用ServerSocket创建服务器
 * 2、阻塞式等待连接 accept
 * 3、操作: 输入输出流操作
 * 4、释放资源 
 * @author 裴新 QQ:3401997271
 *
 */
public class FileServer {

	public static void main(String[] args) throws IOException {
		System.out.println("-----Server-----");
		// 1、指定端口 使用ServerSocket创建服务器
		ServerSocket server =new ServerSocket(8888);
		// 2、阻塞式等待连接 accept
		Socket  client =server.accept(); 
		System.out.println("一个客户端建立了连接");
		// 3、操作: 文件拷贝 存储
		InputStream is =new BufferedInputStream(client.getInputStream());
		OutputStream os =new BufferedOutputStream(new FileOutputStream("src/tcp.png"));
		byte[] flush =new byte[1024];
		int len = -1;
		while((len=is.read(flush))!=-1) {
			os.write(flush,0,len);
		}
		os.flush();
		//3、释放资源 
		os.close();
		is.close();
		
		// 4、释放资源 
		client.close();
		
		server.close();
	}

}
