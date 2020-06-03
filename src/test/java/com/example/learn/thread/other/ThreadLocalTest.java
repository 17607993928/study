package com.example.learn.thread.other;

/**
 * @类描述:
 * @创建人:xiejs
 * @创建时间:
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 200);

    public static void main(String[] args) {
        System.out.println(threadLocal.get());

        Thread thread = new Thread(() -> {
            threadLocal.set(100018);
            System.out.println(Thread.currentThread().getName() + "====" + threadLocal.get());
        }, "小线程");
        thread.start();
    }
}
