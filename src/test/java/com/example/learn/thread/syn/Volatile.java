package com.example.learn.thread.syn;

/**
 * @类描述:volatile
 * @创建人:xiejs
 * @创建时间:2020-6-2 15:12:32
 */
public class Volatile {
    private static volatile int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (num == 0) {

            }
        }).start();
        Thread.sleep(2000);
        num = 1;
    }
}
