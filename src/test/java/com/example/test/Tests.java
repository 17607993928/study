package com.example.test;

import cn.hutool.extra.mail.MailUtil;
import org.junit.jupiter.api.Test;

/**
 * @类描述:测试专用类
 * @创建人:xiejs
 * @创建时间:2020-7-16 14:03:48
 */
public class Tests {

    @Test
    void test() throws InterruptedException {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(5000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        MailUtil.send("761375570@qq.com", "有趣", "邮件来自测试！   "+i+"  ", false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            thread.start();
            thread.join();




        Thread thread1 = Thread.currentThread();
        String name = thread1.getName();
        System.out.println(name);


    }
}
