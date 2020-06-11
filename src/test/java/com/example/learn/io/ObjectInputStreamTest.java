package com.example.learn.io;

import java.io.*;
import java.util.Date;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) {
        try {
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("obj.ser"));

            objectOutputStream.writeObject(new Date());

            ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("obj.ser"));

            Object date = objectInputStream.readObject();

            if(date instanceof Date){
                date=date;
            }

            System.out.println(date);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
