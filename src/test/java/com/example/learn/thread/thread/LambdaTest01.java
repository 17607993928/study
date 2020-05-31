package com.example.learn.thread.thread;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/5/31 0031 下午 15:40
 */
public class LambdaTest01 {

    public static void main(String[] args) {
        Lambda lambda;

        lambda=()->{
            System.out.println("xx");
        };


        Thread lalala = new Thread(() -> {

            for (int i = 0; i < 111; i++) {
                try {
                    Thread.sleep(1111);
                } catch (InterruptedException e) {

                }
                System.out.println("lalala");

            }
        });
        lalala.start();



    }
}
