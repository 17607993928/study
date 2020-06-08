package com.example.learn.io;

import java.io.*;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:2020-6-4 14:00:36
 */
public class IOTest01 {
    public static void main(String[] args) {
        //、创建源
        File file = new File("D:\\新建文本文档.txt");
        File fileCopy = new File("D:\\新建文本文档copy.txt");

        //、选择流
        InputStream inputStream = null;

        OutputStream outputStream=null;

        try {
            inputStream = new FileInputStream(file);
            outputStream=new FileOutputStream(fileCopy);
            //、操作流
            int temp;//一次读取的长度
            byte[] flush = new byte[10];//一次读取的长度
            while ((temp = inputStream.read(flush)) != -1) {
                System.out.println(temp);
                String str = new String(flush, 0, temp);
                System.out.println(str);
//                System.out.println(temp);

                outputStream.write(flush,0,temp);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }if (outputStream != null) {
                    outputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
