package com.example.learn.thread.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
public class SynBlockList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        for (int i = 0; i < 9999; i++) {
            new Thread(() -> {
//                synchronized(list){
                    list.add(Thread.currentThread().getName());
//                }
            }).start();

        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

}

