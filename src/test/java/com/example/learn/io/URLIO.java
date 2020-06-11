package com.example.learn.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @类描述:网络流
 * @创建人:xiejs
 * @创建时间:2020-6-11 14:42:33
 */
public class URLIO {


    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader( new InputStreamReader(new URL("https://www.baidu.com").openStream(),"UTF-8"))){

            String msg="";


            while ((msg=reader.readLine())!=null){
                System.out.println(msg);

            }


        }catch (IOException e){

        }
    }
}
