package com.example.csdn;

/**
 * @类描述:睡眠排序
 * @创建人:xiejs
 * @创建时间:2020-5-9
 */
public class SleepSort {
    public static void main(String[] args) {
        int[] ints = {1, 4, 33, 445, 8, 9, 2, 6, 5};
        SortThread[] sortThreads = new SortThread[ints.length];
        for (int i = 0; i < sortThreads.length; i++) {
            sortThreads[i] = new SortThread(ints[i]);
        }
        for (int i = 0; i < sortThreads.length; i++) {
            sortThreads[i].start();
        }
    }
}

class SortThread extends Thread {
    int ms = 0;

    public SortThread(int ms) {
        this.ms = ms;
    }

    public void run() {
        try {
            sleep(ms * 10 + 10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(ms);
    }
}
