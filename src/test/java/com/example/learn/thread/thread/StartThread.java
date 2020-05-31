package com.example.learn.thread.thread;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
public class StartThread implements Runnable  {
    private boolean flag=true;
    @Override
    public void run() {
        for (int i=0;i<9;i++){
            System.out.println("学习 "+i);

        }

    }

    public static void main(String[] args) {



        /*StartThread startThread=new StartThread();
        Thread thread = new Thread(startThread);
        thread.start();*/

        new Thread(new StartThread()).start();


    }
}
