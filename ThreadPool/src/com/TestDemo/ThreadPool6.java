package com.TestDemo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//创建单个线程的线程池
public class ThreadPool6 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println("线程名：" + Thread.currentThread().getName());
                }
            });
        }
    }
}
