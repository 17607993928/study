package com.example.learn.reflection;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/7/8 0008 下午 20:06
 */
public class Demo03 {

    public static void main(String[] args) throws IOException {
        String helloWorld="public class hello{public static void main(String[] args){System.out.println(12999444);} }";

        OutputStream out=new FileOutputStream(new File("D:/hello.java"));
        BufferedOutputStream bf=new BufferedOutputStream(out);
        byte[] bytes = helloWorld.getBytes();

        out.write(bytes,0,helloWorld.length());

        InputStream in=new FileInputStream(new File("D:/hello.java"));
        BufferedInputStream bfIn=new BufferedInputStream(in);
        int len;
        byte[] bytess=new byte[1024];

        while ((len=bfIn.read(bytess))!=-1){
            String msg=new String(bytess,0,len);
            System.out.println(msg);
        }

        JavaCompiler javaCompiler= ToolProvider.getSystemJavaCompiler();
        int run = javaCompiler.run(null, null, null, "D:/hello.java");

        System.out.println(run);

    }
}
