package com.example.how2j.exception;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
public class TestException {
    public static void main(String[] args){
        File file= null;
        try {
            file = new File("D:/text.txt");
            new FileInputStream(file);
            System.out.println("1");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常");
        } finally {
            System.out.println("最后执行");
            try {
                throw new RuntimeException("啊发顺丰");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    //内存不足异常
    public  void text1() {
        StringBuffer sb =new StringBuffer();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sb.append('a');
        }
    }
}
