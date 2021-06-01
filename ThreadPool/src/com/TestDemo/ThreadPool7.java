package com.TestDemo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//根据当前的cpu生成对应个数的线程池，并且并且是异步。 最大生成的线程数=最大cpu核数
public class ThreadPool7 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newWorkStealingPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" + Thread.currentThread().getName());
                }
            });
        }
        //等待线程池完成
        while(!executorService.isTerminated()) {

        }


    }

}
