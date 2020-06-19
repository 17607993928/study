package com.example.learn.internet;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("------Server------");
        ServerSocket serverSocket=new ServerSocket(9998);

        //获取客户端
        Socket client = serverSocket.accept();

        DataInputStream dataInputStream=new DataInputStream(client.getInputStream());

        System.out.println("一个客户端建立了连接");

        byte[] bytes=new byte[1024];
        int a=0;
        while ((a=dataInputStream.read(bytes))!=-1){
            String s=new String(bytes,0,a);
            System.out.println(s);
        }



    }
}
