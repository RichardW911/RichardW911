package com.TestDemo;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadDemo12 {
    public static void main(String[] args) {
        //创建信号量(车位)
        Semaphore semaphore = new Semaphore(2,true);

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(20,20,0, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1000));

        for (int i = 1; i < 5; i++) {
            int finalI = i;

            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
//                    try {
//                        Thread.sleep(finalI * 10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    System.out.println(Thread.currentThread().getName() + "车辆到达");
                    try {
                        Thread.sleep(4000);
                        //尝试获取锁
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "  ======车辆进入========");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //释放锁
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "车辆离开--------");

                }
            });
            t1.start();
            
        }


    }
}
