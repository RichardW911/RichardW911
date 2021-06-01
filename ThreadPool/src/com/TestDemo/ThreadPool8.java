package com.TestDemo;

import java.util.ArrayList;
import java.util.concurrent.*;


public class ThreadPool8 {
    public static void main(String[] args) {
        //参数1:核心线程的数量，线程池正常情况下数量（正式员工数量）
        //参数2:最大线程数量，当有大量任务的时候可以创建的最多的线程数（零时工）
        //参数3:最大线程存活时间（零时工的存活时间）
        //参数4:时间单位
        //参数5:任务缓存队列
        //参数6:线程工厂
        //参数7:拒绝策略
        ThreadFactory threadFactory = new ThreadFactory() {
            private int count = 1;
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setName("MyThreadPool-" + count++);
                return thread;
            }
        };


        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(1,
                        8,
                        60,
                        TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(10),
                        threadFactory,
                        new ThreadPoolExecutor.AbortPolicy()
                );
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" + Thread.currentThread().getName());
                }
            });

        }
    }

}
