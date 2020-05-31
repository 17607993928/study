package com.example.learn.thread;

/**
 * @创建人 xjs
 * @类描述 TODO
 * @创建时间 2020/5/31 0031 下午 16:57
 */
public class Join {

    public static void main(String[] args) {
        System.out.println("抽烟的故事");
        new Thread(new father()).start();
    }

}

class father implements Runnable{
    @Override
    public void run() {
        System.out.println("让儿子去买烟");
        son son = new son();
        Thread thread = new Thread(son);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {


        }


        System.out.println("接过儿子的烟");

    }
}

class son implements Runnable{

    @Override
    public void run() {
        System.out.println("出门买烟去");
        System.out.println("路边发现了游戏厅，进去玩了10秒");
        for(int i=1;i<=10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {


            }
            System.out.println("第"+i+"秒");
        }
        System.out.println("买烟回来了");
    }
}
