package com.example.learn.internet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("------Client------");
        Socket client=new Socket("localhost",9998);

        DataInputStream dataInputStream=new DataInputStream(client.getInputStream());

        DataOutputStream dataOutputStream=new DataOutputStream(client.getOutputStream());

        String data="你是傻逼";

        dataOutputStream.writeUTF(data);
        dataOutputStream.flush();
        client.close();
    }
}
