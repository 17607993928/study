package com.example.learn.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
public class IOTest02 {
    public static void main(String[] args) {
        File file=new File("ddd.txt");


        OutputStream outputStream=null;
        try {
            outputStream=new FileOutputStream(file,false);

            String msg="我是你爸爸";
            byte[] flush=msg.getBytes();
            outputStream.write(flush,0,flush.length);

            outputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }





}
