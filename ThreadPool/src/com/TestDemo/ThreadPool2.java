package com.TestDemo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//创建带缓存的线程池
//短期有大量任务的时候使用 newCachedThreadPool
public class ThreadPool2 {
    public static void main(String[] args) {


        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名："+Thread.currentThread().getName());
                }
            });
        }
    }
}
