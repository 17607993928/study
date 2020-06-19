package com.example.learn.internet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:2020-6-12 14:00:06
 */
public class URLTest01 {
    public static void main(String[] args) throws IOException {
        URL url=new URL("https://www.dianping.com");
        int port = url.getPort();
        String file = url.getFile();
        String query = url.getQuery();
        InputStream inputStream = url.openStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        int read = 0;
        byte[] bytes = new byte[1024*1000];
        while ((read=bufferedInputStream.read(bytes))!=-1){
            String str = new String(bytes, 0, read);
            System.out.println(str);
        }
        System.out.println(port);
        System.out.println(file);
        System.out.println(query);
    }
}

class URLTest02{
    public static void main(String[] args) throws IOException {
        URL url=new URL("https://www.dianping.com");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
        int read = 0;
        byte[] bytes = new byte[1024*1000];
        while ((read=bufferedInputStream.read(bytes))!=-1){
            String str = new String(bytes, 0, read);
            System.out.println(str);
        }
    }
}
