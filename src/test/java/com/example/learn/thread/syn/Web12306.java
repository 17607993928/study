package com.example.learn.thread.syn;

/**
 * @类描述:线程安全，在并发时保持数据准确性（synchronized）
 * @创建人:xiejs
 * @创建时间:
 */
public class Web12306 implements Runnable {
    private int num = 9999;
    private boolean flag = true;


    @Override
    public void run() {

        while (flag) {


            test();

            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }

    public static void main(String[] args) {
        Web12306 web = new Web12306();
        new Thread(web, "father").start();
        new Thread(web, "son").start();
        new Thread(web, "mather").start();

    }

    private synchronized void test() {
        if (num <= 0) {
            flag = false;
            return;
        }

        System.out.println(Thread.currentThread().getName() + "----------" + "还剩" + num-- + "票");
    }
}
