package com.example.how2j.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
public class TestIO {
    @Test
    public void testIO() {

        try {
            File file=new File("D:/新建文本文档1.txt");
            FileReader fileInputStream=new FileReader(file);
            char [] b=new char[(int) file.length()];
            fileInputStream.read(b);
            for (char b1 : b) {
                System.out.print(b1);
            }
            System.out.println("111");
        } catch (IOException e) {
            String message = e.getMessage();
            System.out.println("已经捕获异常:"+message);
            return;
        } finally {
            System.out.println("z啧啧啧啧");
        }


    }
}
