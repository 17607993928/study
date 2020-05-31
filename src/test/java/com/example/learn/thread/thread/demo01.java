package com.example.learn.thread.thread;

import java.util.concurrent.*;

/**
 * @类描述:创建线程
 * @创建人:xiejs
 * @创建时间:2020-5-13
 */
public class demo01 {

    //内部类(继承Thread类)
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("我要启动了   继承Thread类");
        }
    }

    /*//内部类(实现runnable接口)
    public static class MyThread implements Runnable{


        @Override
        public void run() {

        }
    }*/

    static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(10000);
            return 2;
        }

        public static void main(String[] args) throws ExecutionException, InterruptedException {
            ExecutorService executor = Executors.newCachedThreadPool();
            Task task = new Task();
            Future<Integer> result = executor.submit(task);
            System.out.println(result.get());
        }

    }




    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            System.out.println("testThread当前线程组名字：" + Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字：" + Thread.currentThread().getName());
        });
        thread.start();
//        System.out.println(Thread.currentThread().getName());

        System.out.println("获取线程组的名称"+Thread.currentThread().getThreadGroup().getName());

    }
}
