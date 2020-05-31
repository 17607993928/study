package com.example.learn.thread.syn;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
public class Web12306 implements Runnable{
    private  int  num=99;


    @Override
    public void run() {

        while (true){
            num--;
            System.out.println(Thread.currentThread().getName()+"----------"+"还剩"+num+"票");
            if(num<=0){
                break;
            }


        }

    }

    public static void main(String[] args) {
        Web12306 web = new Web12306();
        new Thread(web,"father").start();
        new Thread(web,"son").start();
        new Thread(web,"mather").start();

    }
}
