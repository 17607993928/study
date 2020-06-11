package com.example.learn.io.io;

import java.io.*;

/**
 * @类描述:分装io
 * @创建人:xiejs
 * @创建时间:
 */
public class FileUtil {

    public static void copy(InputStream in, OutputStream ou){
        try {
            //、操作流
            int temp;//一次读取的长度
            byte[] flush = new byte[10];//一次读取的长度
            while ((temp = in.read(flush)) != -1) {
                System.out.println(temp);
                String str = new String(flush, 0, temp);
                System.out.println(str);
//                System.out.println(temp);

                ou.write(flush,0,temp);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(in,ou);
        }
    }

    public static void copyByte(InputStream in,OutputStream ou){

    }

    public static void close(InputStream in,OutputStream ou){
        try {
            if (in != null) {
                in.close();
            }
            if (ou != null) {
                ou.close();
            }if (ou != null) {
                ou.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
