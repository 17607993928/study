package com.example.learn.dynamic.reflection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/8 0008 下午 19:39
 */
public class Demo02 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Runtime runtime=Runtime.getRuntime();
        Process ipconfig = runtime.exec("java -cp D:/ hello");

        InputStream inputStream = ipconfig.getInputStream();

        BufferedReader read=new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
        String msg="";

        while ((msg=read.readLine())!=null){
            System.out.println(msg);
        }



        URL[] urls=new URL[]{new URL("file:/"+"D:/")};
        URLClassLoader loader=new URLClassLoader(urls);
        Class<?> clazz = loader.loadClass("hello");
        Method m = clazz.getMethod("main", String[].class);
        m.invoke(null,(Object) new String[] {});


    }



}
