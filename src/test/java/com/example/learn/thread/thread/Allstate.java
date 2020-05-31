package com.example.learn.thread.thread;

import java.lang.Thread.State;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/5/31 0031 下午 17:23
 */
public class Allstate implements Runnable{
    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            System.out.println("xxx");
        });
        thread.start();
        State state=thread.getState();

        System.out.println(state);

        new Thread(new Allstate()).start();
    }

    @Override
    public void run() {
        System.out.println("cccc");
    }
}
