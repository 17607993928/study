package com.example.learn.thread.thread;

/**
 * @创建人 xjs
 * @类描述 守护线程
 * @创建时间 2020/5/31 0031 下午 17:50
 */
public class Guard {
    public static void main(String[] args) {
        Thread thread = new Thread(new god());
        thread.setDaemon(true);
        thread.start();
        new Thread(new you()).start();

    }
}

class you implements Runnable {

    @Override
    public void run() {

        for (int i = 1; i <= 365; i++) {
            System.out.println("你还在");
        }
        System.out.println("你不在了");
    }
}

class god implements Runnable {

    @Override
    public void run() {

        while (true){
            System.out.println("上帝一直都在");
        }

    }

}


