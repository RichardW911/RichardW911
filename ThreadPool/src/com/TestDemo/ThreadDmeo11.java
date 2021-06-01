package com.TestDemo;

import java.util.concurrent.atomic.AtomicInteger;


public class ThreadDmeo11 {

    private static final AtomicInteger count = new AtomicInteger();

    private static final int MAXSIZE = 10_0000;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < MAXSIZE; i++) {
                    count.incrementAndGet();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < MAXSIZE; i++) {
                    count.decrementAndGet();
                }
            }
        });
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
    }
}
